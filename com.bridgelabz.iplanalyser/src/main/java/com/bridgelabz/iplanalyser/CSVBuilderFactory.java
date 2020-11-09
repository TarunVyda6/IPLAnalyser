package com.bridgelabz.iplanalyser;

public class CSVBuilderFactory
{
	public static <E> OpenCsvBuilder<E> createCSVBuilder()
	{
		return new OpenCsvBuilder<E>();
	}

}
