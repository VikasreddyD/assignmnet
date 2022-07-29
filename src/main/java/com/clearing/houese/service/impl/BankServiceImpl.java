package com.clearing.houese.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clearing.houese.dao.BankDetailsDao;
import com.clearing.houese.model.BankDetails;
import com.clearing.houese.service.BankService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

	private final BankDetailsDao bankDetailsDao;

	@Override
	public List<BankDetails> searchBankDetails(String zipCode, String state, String city, String type, String name) {
		return bankDetailsDao.searchBankDetails(zipCode, state, city, type, name);
	}

}
