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
	public void givenIPLData_WhenAnalyse_ShouldReturn_HighestBattingAveragePerson() throws CSVException
	{
		List<IPLBatting> highestBattingAvg = iplAnalyser.sortByBattingAverageDescending(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("MS Dhoni", highestBattingAvg.get(0).getPlayer());
	}
	
	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturn_HighestBattingStrikeRatePerson() throws CSVException
	{
		List<IPLBatting> highestBattingAvg = iplAnalyser.sortByBattingStrikeRateDescending(IPL_BATTING_CSV_FILE_PATH);
		assertEquals("Ishant Sharma", highestBattingAvg.get(0).getPlayer());
	}

}
