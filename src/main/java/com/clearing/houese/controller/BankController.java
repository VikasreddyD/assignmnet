package com.clearing.houese.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clearing.houese.model.BankDetails;
import com.clearing.houese.service.BankService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

	private final BankService bankService;

	@GetMapping("/search")
	public ResponseEntity<List<BankDetails>> searchBankDetails(
			@RequestParam(value = "zipCode", required = false) String zipCode,
			@RequestParam(value = "state", required = false) String state,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "name", required = false) String name) {
		return ResponseEntity.status(HttpStatus.OK.value())
				.body(bankService.searchBankDetails(zipCode, state, city, type, name));
	}

}
