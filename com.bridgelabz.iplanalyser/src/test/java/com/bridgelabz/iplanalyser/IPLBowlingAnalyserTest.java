package com.bridgelabz.iplanalyser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IPLBowlingAnalyserTest
{
	private static final String IPL_BOWLING_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostWkts.csv";
	IPLAnalyser iplAnalyser;

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException
	{
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnBestBowlingAveragePerson() throws CSVException
	{
		List<IPLBowling> bestBowlingAverage = iplAnalyser.sortByBowlingAverage(IPL_BOWLING_CSV_FILE_PATH);
		assertEquals("Anukul Roy", bestBowlingAverage.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnBestBowlingStrikeRatePerson() throws CSVException
	{
		List<IPLBowling> bestBowlingStrikeRate = iplAnalyser.sortByBowlingStrikeRate(IPL_BOWLING_CSV_FILE_PATH);
		assertEquals("Alzarri Joseph", bestBowlingStrikeRate.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnBestBowlingEconomyPerson() throws CSVException
	{
		List<IPLBowling> bestBowlingEconomy = iplAnalyser.sortByBowlingEconomy(IPL_BOWLING_CSV_FILE_PATH);
		assertEquals("Shivam Dube", bestBowlingEconomy.get(0).getPlayer());
	}
}
