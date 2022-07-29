package com.clearing.houese.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clearing.houese.model.BankDetails;

@Repository
public interface BankDetailsDao extends JpaRepository<BankDetails, Long> {

	@Query("SELECT bank from BankDetails bank where (:zipcode is null or bank.zipcode=:zipcode) and"
			+ " (:state is null or bank.state=:state) and (:city is null or bank.city=:city)  and "
			+ "(:type is null or bank.type=:type) and (:name is null or bank.name=:name)")
	List<BankDetails> searchBankDetails(@Param("zipcode") String zipcode, @Param("state") String state,
			@Param("city") String city, @Param("type") String type, @Param("name") String name);
}
