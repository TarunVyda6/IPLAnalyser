package com.bridgelabz.iplanalyser;

import com.opencsv.bean.CsvBindByName;

public class IPLBatting
{

	@CsvBindByName(column = "POS", required = true)
	private String position;
	@CsvBindByName(column = "PLAYER", required = true)
	private String player;
	@CsvBindByName(column = "MAT")
	private int match;
	@CsvBindByName(column = "Inns")
	private int innings;
	@CsvBindByName(column = "NO")
	private int notOut;
	@CsvBindByName(column = "Runs")
	private int runs;
	@CsvBindByName(column = "HS")
	private String highestScore;
	@CsvBindByName(column = "Avg")
	private String average;
	@CsvBindByName(column = "BF")
	private int ballFaced;
	@CsvBindByName(column = "SR")
	private String strikeRate;
	@CsvBindByName(column = "100")
	private int century;
	@CsvBindByName(column = "50")
	private int halfCentury;
	@CsvBindByName(column = "4s")
	private int fours;
	@CsvBindByName(column = "6s")
	private int sixes;

	public String getAverage()
	{
		try
		{
			Double.parseDouble(average);
			return average;
		}
		catch (NumberFormatException e)
		{
			return "0";
		}
	}

	public String getStrikeRate()
	{
		try
		{
			return strikeRate;
		}
		catch (NumberFormatException e)
		{
			return "0";
		}
	}

	public int getSixes()
	{
			return sixes;
	}
	
	public int getFours()
	{
			return fours;
	}
	
	public String getPlayer()
	{
		return player;
	}

	@Override
	public String toString()
	{
		return "IPLBatting [position=" + position + ", player=" + player + ", match=" + match + ", innings=" + innings
				+ ", notOut=" + notOut + ", runs=" + runs + ", highestScore=" + highestScore + ", average=" + average
				+ ", ballFaced=" + ballFaced + ", strikeRate=" + strikeRate + ", century=" + century + ", halfCentury="
				+ halfCentury + ", fours=" + fours + ", sixes=" + sixes + "]";
	}
}
