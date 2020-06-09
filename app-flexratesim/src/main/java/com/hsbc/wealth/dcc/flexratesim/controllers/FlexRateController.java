package com.hsbc.wealth.dcc.flexratesim.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.wealth.dcc.flexratesim.dto.FlexSimulatorResponseDto;
import com.hsbc.wealth.dcc.flexratesim.service.FlexRateService;

@RestController
@RequestMapping("/flex")
@CrossOrigin
public class FlexRateController {

	@Autowired
	private FlexRateService flexSimulatorService;

	@GetMapping(value = "/rates", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlexSimulatorResponseDto> getRates(@RequestParam("primaryCurrency") String primaryCurrency,
			@RequestParam("secondaryCurrency") String secondaryCurrency) {
		FlexSimulatorResponseDto response = flexSimulatorService.getRates(primaryCurrency, secondaryCurrency);
		return ResponseEntity.ok(response);

	}

}
