package com.clearing.houese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.clearing.houese.util.LoadBankData;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class HoueseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HoueseApplication.class, args);
		try {
			context.getBean(LoadBankData.class).loadBankData();
		} catch (Exception e) {
			log.error("Error in loading bank data.");
			e.printStackTrace();
		}
	}

}
