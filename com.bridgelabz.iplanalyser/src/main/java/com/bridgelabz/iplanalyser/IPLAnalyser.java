package com.bridgelabz.iplanalyser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser
{

	private List<IPLBatting> iplBattingList;
	private List<IPLBowling> iplBowlingList;
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

	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on fours in sorted descending order
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByMaximumFoursDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList, Comparator.comparing(batting -> batting.getFours()));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on maximum sixes and fours with best strike rate
	 *         in sorted descending order
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByMaximumSixesAndFoursWithBestStrikeRateDescending(String iplBattingCsvFilePath)
			throws CSVException
	{

		checkingForExceptionsAndFetchingData(iplBattingCsvFilePath);
		Collections.sort(iplBattingList,
				Comparator.comparing(batting -> batting.getFours() * 4 + batting.getSixes() * 6));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on best strike rate and average in sorted
	 *         descending order
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByBestStrikeRateAndAverageDescending(String iplBattingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingData(iplBattingCsvFilePath);
		sortByBattingStrikeRateDescending(iplBattingCsvFilePath)
				.sort(Comparator.comparing(batting -> Double.parseDouble(batting.getAverage())));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}

	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on best average with maximum runs in sorted
	 *         descending order
	 * @throws CSVException
	 */
	public List<IPLBatting> sortByBestAverageAndMaximumRunsDescending(String iplBattingCsvFilePath) throws CSVException
	{
		sortByBattingAverageDescending(iplBattingCsvFilePath).sort(Comparator.comparing(batting -> batting.getRuns()));
		Collections.reverse(iplBattingList);
		return iplBattingList;
	}
	
	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on best bowling average
	 * @throws CSVException
	 */
	public List<IPLBowling> sortByBowlingAverage(String iplBowlingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingBowlingData(iplBowlingCsvFilePath);
		Collections.sort(iplBowlingList, Comparator.comparing(bowling ->  Double.parseDouble(bowling.getAverage())));
		return iplBowlingList;
	}
	
	/**
	 * @param iplBattingCsvFilePath
	 * @return players data based on best bowling strike rate
	 * @throws CSVException
	 */
	public List<IPLBowling> sortByBowlingStrikeRate(String iplBowlingCsvFilePath) throws CSVException
	{
		checkingForExceptionsAndFetchingBowlingData(iplBowlingCsvFilePath);
		Collections.sort(iplBowlingList, Comparator.comparing(bowling ->  Double.parseDouble(bowling.getStrikeRate())));
		return iplBowlingList;
	}
	

	/**
	 * @param csvFilePath check for exception and retrieve the batting information from csv
	 *                    file
	 * @throws CSVException
	 */
	private void checkingForExceptionsAndFetchingData(String csvFilePath) throws CSVException
	{
		iplBattingList = csvFileLoader.loadBattingStats(csvFilePath);
		if (iplBattingList == null || iplBattingList.isEmpty())
			throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);
	}

	/**
	 * @param csvFilePath check for exception and retrieve the bowling information from csv
	 *                    file
	 * @throws CSVException
	 */
	private void checkingForExceptionsAndFetchingBowlingData(String csvFilePath) throws CSVException
	{
		iplBowlingList = csvFileLoader.loadBowlingStats(csvFilePath);
		if (iplBowlingList == null || iplBowlingList.isEmpty())
			throw new CSVException("No Census data found", CSVException.ExceptionType.NO_CENSUS_DATA);
	}



	

}
