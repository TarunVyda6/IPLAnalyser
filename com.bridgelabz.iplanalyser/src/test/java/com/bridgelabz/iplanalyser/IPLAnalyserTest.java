package com.bridgelabz.iplanalyser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IPLAnalyserTest
{

	private static final String IPL_BATTING_CSV_FILE_PATH = "E:\\Experiments\\IplLeagueAnalysis\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
	IPLAnalyser iplAnalyser;

	@Before
	public void initializer()
	{
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnHighestBattingAveragePerson() throws CSVException
	{
		List<IPLBatting> highestBattingAvg = iplAnalyser.sortByBattingAverageDescending(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("MS Dhoni", highestBattingAvg.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnHighestBattingStrikeRatePerson() throws CSVException
	{
		List<IPLBatting> highestBattingStrikeRate = iplAnalyser
				.sortByBattingStrikeRateDescending(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("Ishant Sharma", highestBattingStrikeRate.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnMaximumSixHittingPerson() throws CSVException
	{
		List<IPLBatting> maximumSixes = iplAnalyser.sortByMaximumSixesDescending(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("Andre Russell", maximumSixes.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnMaximumFoursHittingPerson() throws CSVException
	{
		List<IPLBatting> maximumFours = iplAnalyser.sortByMaximumFoursDescending(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("Shikhar Dhawan", maximumFours.get(0).getPlayer());
	}

}
