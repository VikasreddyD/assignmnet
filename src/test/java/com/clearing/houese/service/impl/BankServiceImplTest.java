package com.clearing.houese.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clearing.houese.dao.BankDetailsDao;
import com.clearing.houese.model.BankDetails;

@RunWith(SpringJUnit4ClassRunner.class)
public class BankServiceImplTest {

	private static final String ZIPCODE = "10018";
	private static final String NAME = "Amazing Bank";
	private static final String TYPE = "Branch";
	private static final String CITY = "New York";
	private static final String STATE = "NY";
	private static final Long ID = 1L;

	@InjectMocks
	private BankServiceImpl bankServiceImpl;

	@Mock
	private BankDetailsDao bankDetailsDao;

	@Test
	public void searchBankDetails_Success() throws Exception {
		List<BankDetails> bankDetailsList = new ArrayList<BankDetails>();
		BankDetails bankDetails = BankDetails.builder().city(CITY).id(ID).name(NAME).state(STATE).type(TYPE)
				.zipcode(ZIPCODE).build();
		bankDetailsList.add(bankDetails);
		Mockito.when(bankDetailsDao.searchBankDetails(ZIPCODE, STATE, CITY, TYPE, NAME)).thenReturn(bankDetailsList);
		List<BankDetails> searchResponse = bankServiceImpl.searchBankDetails(ZIPCODE, STATE, CITY, TYPE, NAME);
		Assert.assertNotNull(searchResponse);
		Assert.assertEquals(bankDetailsList.size(), searchResponse.size());
	}

	@Test
	public void searchBankDetails_WithEmptyList() throws Exception {
		List<BankDetails> bankDetailsList = new ArrayList<BankDetails>();
		Mockito.when(bankDetailsDao.searchBankDetails(ZIPCODE, STATE, CITY, TYPE, NAME)).thenReturn(bankDetailsList);
		List<BankDetails> searchResponse = bankServiceImpl.searchBankDetails(ZIPCODE, STATE, CITY, TYPE, NAME);
		Assert.assertNotNull(searchResponse);
		Assert.assertEquals(bankDetailsList.size(), searchResponse.size());
	}

}
