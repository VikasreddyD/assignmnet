package com.clearing.houese.service;

import java.util.List;

import com.clearing.houese.model.BankDetails;

public interface BankService {

	List<BankDetails> searchBankDetails(String zipCode, String state, String city, String type, String name);

}
