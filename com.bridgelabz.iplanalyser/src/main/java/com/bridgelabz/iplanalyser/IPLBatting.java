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
	private double strikeRate;
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

	public double getStrikeRate()
	{
		return strikeRate;
	}

	public int getSixes()
	{
		return sixes;
	}

	public int getFours()
	{
		return fours;
	}

	public int getRuns()
	{
		return runs;
	}

	public String getPlayer()
	{
		return player;
	}

	public int getCentury()
	{
		return century;
	}

	public int getHalfCentury()
	{
		return halfCentury;
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
