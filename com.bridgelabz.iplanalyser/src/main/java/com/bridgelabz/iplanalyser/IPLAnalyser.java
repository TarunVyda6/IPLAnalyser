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
	 * @return players data based on batting average in sorted descending order
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByBattingAverageDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList, Comparator.comparing(batting -> Double.parseDouble(batting.getAverage())));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on batting strike rate in sorted descending order
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByBattingStrikeRateDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList, Comparator.comparing(batting -> Double.parseDouble(batting.getStrikeRate())));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on sixes in sorted descending order
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByMaximumSixesDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList, Comparator.comparing(batting -> batting.getSixes()));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	public List<IPLBatting> sortByMaximumFoursDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList, Comparator.comparing(batting -> batting.getFours()));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	/**
	 * @param csvFilePath check for exception and retrieve the information from csv
	 *                    file
	 * @throws CSVException
	 */
	private void checkingForExceptionsAndFetchingData(String csvFilePath) throws CSVException
	{
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		if (iplBattingList == null || iplBattingList.isEmpty())
			throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);
	}

}
