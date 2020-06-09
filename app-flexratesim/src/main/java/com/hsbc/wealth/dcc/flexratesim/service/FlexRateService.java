package com.hsbc.wealth.dcc.flexratesim.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsbc.wealth.dcc.flexratesim.dao.FlexRateDAO;
import com.hsbc.wealth.dcc.flexratesim.dto.FlexSimulatorResponseDto;

@Service
public class FlexRateService {
	@Autowired
	private FlexRateDAO flexRateDAO;

	public FlexSimulatorResponseDto getRates(String primaryCurrency, String secondaryCurrency) {

		FlexSimulatorResponseDto flexSimulatorResponseDto = null;

		Random rand = new Random();
		if (primaryCurrency != null && secondaryCurrency != null) {
			flexSimulatorResponseDto = flexRateDAO.getrateByCurrencyPairs(primaryCurrency, secondaryCurrency);
		}
		return flexSimulatorResponseDto;
	}
}
