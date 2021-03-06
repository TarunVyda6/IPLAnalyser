package com.bridgelabz.iplanalyser;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.csvreader.CSVException;

public class IPLAnalyser
{

	private CsvFileLoader csvFileLoader;

	public IPLAnalyser()
	{
		csvFileLoader = new CsvFileLoader();
	}

	/**
	 * @param <E>
	 * @param csvFilePath
	 * @param comparator
	 * @param csvClass
	 * @return list of ipl data from csv file according to our requirements
	 * @throws CSVException
	 */
	public <E> List<E> sortData(String csvFilePath, Comparator comparator, Class<E> csvClass) throws CSVException
	{
		List<E> iplList = csvFileLoader.loadStats(csvFilePath, csvClass);
		return (List<E>) iplList.stream().sorted(comparator).collect(Collectors.toList());
	}

	/**
	 * @param batsmanFilePath
	 * @param bowlerFilePath
	 * @param comparator
	 * @return all-rounders data by taking batting and bowling data
	 * @throws CSVException
	 */
	public List<IPLAllRounder> sortAllrounderData(String batsmanFilePath, String bowlerFilePath,
			Comparator<IPLAllRounder> comparator) throws CSVException
	{

		List<IPLAllRounder> iplAllRounderList = csvFileLoader.loadStats(batsmanFilePath, bowlerFilePath);
		return iplAllRounderList.stream().sorted(comparator).collect(Collectors.toList());
	}

}
