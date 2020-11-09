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
	public void initializer() throws NoSuchFieldException, SecurityException {
		iplAnalyser = new IPLAnalyser();
	}
	
	@Test
	public void givenIPLData_WhenAnalyse_ShouldReturnHighestBattingAveragePerson() throws CSVException
	{
		List<IPLBowling> BestBowlingAverage = iplAnalyser.sortByBowlingAverage(IPL_BOWLING_CSV_FILE_PATH);
		assertEquals("Anukul Roy", BestBowlingAverage.get(0).getPlayer());
	}
}
