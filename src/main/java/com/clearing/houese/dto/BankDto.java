package com.clearing.houese.dto;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BankDto {

	@CsvBindByPosition(position = 1)
	private String name;

	@CsvBindByPosition(position = 2)
	private String type;

	@CsvBindByPosition(position = 3)
	private String city;

	@CsvBindByPosition(position = 4)
	private String state;

	@CsvBindByPosition(position = 5)
	private String zipcode;

}
