package com.clearing.houese.util;

import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clearing.houese.dao.BankDetailsDao;
import com.clearing.houese.dto.BankDto;
import com.clearing.houese.model.BankDetails;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class LoadBankData {

	@Autowired
	private BankDetailsDao bankDetailsDao;

	public String loadBankData() throws Exception {
		URL resource = getClass().getClassLoader().getResource("ProgrammingAssignment.csv");
		List<BankDto> bankDtoList = new CsvToBeanBuilder(new FileReader(resource.getPath())).withType(BankDto.class)
				.build().parse();
		List<BankDetails> bankDetailsList = new ArrayList<BankDetails>();
		for (BankDto bankDto : bankDtoList) {
			BankDetails bankDetails = BankDetails.builder().city(bankDto.getCity()).name(bankDto.getName())
					.state(bankDto.getState()).type(bankDto.getType()).zipcode(bankDto.getZipcode()).build();
			bankDetailsList.add(bankDetails);
			bankDetailsDao.saveAll(bankDetailsList);
		}
		return "Bank details Saved Successfully.";
	}

}
