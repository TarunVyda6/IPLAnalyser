package com.bridgelabz.iplanalyser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser
{

	private List<IPLBatting> iplBattingList;
	private CsvFileLoader csvFileLoader;

	public IPLAnalyser()
	{
		csvFileLoader = new CsvFileLoader();
	}

	/**
	 * @param csvFilePath
	 * @return
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByBattingAverageDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndReturningData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList, Comparator.comparing(batting -> Double.parseDouble(batting.getAverage())));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	public List<IPLBatting> sortByBattingStrikeRateDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndReturningData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList, Comparator.comparing(batting -> Double.parseDouble(batting.getStrikeRate())));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	private void checkingForExceptionsAndReturningData(String csvFilePath) throws CSVException
	{
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		if (iplBattingList == null || iplBattingList.isEmpty())
			throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);

	}

}
