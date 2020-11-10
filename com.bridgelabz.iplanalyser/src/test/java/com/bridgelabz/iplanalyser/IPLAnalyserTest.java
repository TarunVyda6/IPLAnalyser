package com.bridgelabz.iplanalyser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.csvreader.CSVException;

public class IPLAnalyserTest
{

	private static final String IPL_BATTING_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostRuns.csv";
	IPLAnalyser iplAnalyser;
	List<IPLBatting> sortedBattingList;

	@Before
	public void initializer()
	{
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasHighestBattingAverage() throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.BEST_BATTING_AVG,
				IPLBatting.class);
		assertEquals("MS Dhoni", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasHighestBattingStrikeRate() throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.BEST_SR,
				IPLBatting.class);
		assertEquals("Ishant Sharma", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasMaximumSix() throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.MOST_SIXES,
				IPLBatting.class);
		assertEquals("Andre Russell", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasMaximumFours() throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.MOST_FOURS,
				IPLBatting.class);
		assertEquals("Shikhar Dhawan", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasMaximumSixesAndFoursWithBestStrikeRate()
			throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.MAX_SR_WITH_MOST_6s4s,
				IPLBatting.class);
		assertEquals("Andre Russell", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestStrikeRateAndAverage() throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.BEST_AVG_WITH_BEST_SR,
				IPLBatting.class);
		assertEquals("MS Dhoni", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestAverageAndMaximumRuns() throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH, SortingComparators.MAX_RUNS_BEST_SR,
				IPLBatting.class);
		assertEquals("David Warner", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestAverageAndMaximumHundreds() throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH,
				SortingComparators.MOST_HUNDREDS_WITH_BEST_AVG, IPLBatting.class);
		assertEquals("David Warner", sortedBattingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestAverageButNoCenturyOrHalfCentury()
			throws CSVException
	{
		sortedBattingList = iplAnalyser.sortData(IPL_BATTING_CSV_FILE_PATH,
				SortingComparators.BEST_AVG_WITH_ZERO_100s_50s, IPLBatting.class);
		assertEquals("Marcus Stoinis", sortedBattingList.get(0).getPlayer());
	}
}
