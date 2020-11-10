package com.bridgelabz.iplanalyser;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.csvreader.CSVException;

public class IPLAllRounderAnalyserTest
{

	private static final String IPL_BATTING_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostRuns.csv";
	private static final String IPL_BOWLING_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostWkts.csv";
	IPLAnalyser iplAnalyser;
	List<IPLAllRounder> sortedAllrounderList;

	@Before
	public void initializer() throws NoSuchFieldException, SecurityException
	{
		iplAnalyser = new IPLAnalyser();
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasBestBattingAndBowlingAverage() throws CSVException
	{
		sortedAllrounderList = iplAnalyser.sortAllrounderData(IPL_BATTING_CSV_FILE_PATH, IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.BEST_BATTING_AND_BOWLING_AVG);
		assertEquals("Andre Russell", sortedAllrounderList.get(0).getPlayer());
	}

	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnPersonWhoHasScoredMostRunsAndTookMostWickets() throws CSVException
	{
		sortedAllrounderList = iplAnalyser.sortAllrounderData(IPL_BATTING_CSV_FILE_PATH, IPL_BOWLING_CSV_FILE_PATH,
				SortingComparators.BEST_ALLROUNDER);
		assertEquals("Hardik Pandya", sortedAllrounderList.get(0).getPlayer());
	}

}
