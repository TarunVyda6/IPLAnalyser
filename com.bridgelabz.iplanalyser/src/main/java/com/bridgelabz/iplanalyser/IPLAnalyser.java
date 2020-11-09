package com.bridgelabz.iplanalyser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.csvreader.CSVException;

public class IPLAnalyser
{

	private CsvFileLoader csvFileLoader;

	public IPLAnalyser()
	{
		csvFileLoader = new CsvFileLoader();
	}

	public <E> List<E> sortData(String csvFilePath, Comparator comparator, Class<E> csvClass) throws CSVException
	{
		List<E> iplList = csvFileLoader.loadStats(csvFilePath, csvClass);
		return (List<E>) iplList.stream().sorted(comparator).collect(Collectors.toList());
	}
}
