package com.hsbc.wealth.dcc.flexratesim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hsbc.wealth.dcc.flexratesim.dto.FlexSimulatorResponseDto;

@Repository
public class FlexRateDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String query = "select * from rates_table where primary_currency =? and secondary_currency=?";

	public FlexSimulatorResponseDto getrateByCurrencyPairs(String primaryCurrency, String secondaryCurrency) {

		FlexSimulatorResponseDto flexSimulatorResponseDto = jdbcTemplate.queryForObject(query,
				new Object[] { primaryCurrency, secondaryCurrency }, new RowMapper<FlexSimulatorResponseDto>() {

					public FlexSimulatorResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						Random rand = new Random();
						FlexSimulatorResponseDto flexSimulatorResponseDto = new FlexSimulatorResponseDto();
						flexSimulatorResponseDto.setId(rs.getInt("id"));
						flexSimulatorResponseDto.setCrossRate(rs.getDouble("cross_rate"));
						flexSimulatorResponseDto.setPrimaryCurrency(rs.getString("primary_currency"));
						flexSimulatorResponseDto.setSecondaryCurrency(rs.getString("secondary_currency"));
						flexSimulatorResponseDto.setQuote(rand.nextInt(1000));
						return flexSimulatorResponseDto;
					}
				});

		return flexSimulatorResponseDto;
	}
}
