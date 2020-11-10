package com.bridgelabz.iplanalyser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.csvreader.CSVException;

public class IPLBowlingAnalyserTest
{
	private static final String IPL_BOWLING_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostWkts.csv";
	IPLAnalyser iplAnalyser;
	List<IPLBowling> sortedBowlingList;

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException
	{
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestBowlingAverage() throws CSVException
	{
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_BOWLING_AVG,
				IPLBowling.class);
		assertEquals("Anukul Roy", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestBowlingStrikeRate() throws CSVException
	{
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_BOWLING_SR,
				IPLBowling.class);
		assertEquals("Alzarri Joseph", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestBowlingEconomy() throws CSVException
	{
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_ECONOMY_BOWLER,
				IPLBowling.class);
		assertEquals("Shivam Dube", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestStrikeRateWith5WicketsAnd4Wickets()
			throws CSVException
	{
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH, SortingComparators.BEST_SR_WITH_5W4W,
				IPLBowling.class);
		assertEquals("Kagiso Rabada", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestStrikeRateWithBestBowlingAverage()
			throws CSVException
	{
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.BEST_BOWLING_AVG_WITH_BEST_SR, IPLBowling.class);
		assertEquals("Alzarri Joseph", sortedBowlingList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturn_PersonWhoTookMaximumWicketsWithBestBowlingAverage()
			throws CSVException
	{
		sortedBowlingList = iplAnalyser.sortData(IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.MAX_WKTS_WITH_BEST_BOWLING_AVG, IPLBowling.class);
		assertEquals("Imran Tahir", sortedBowlingList.get(0).getPlayer());
	}
}
