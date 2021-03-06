package com.bridgelabz.iplanalyser;

import java.util.Comparator;

public class SortingComparators
{
	/* Batting data sorting comparators */
	public static final Comparator<Object> BEST_BATTING_AVG = Comparator
			.comparing(batting -> Double.parseDouble(((IPLBatting) batting).getAverage())).reversed();
	public static final Comparator<IPLBatting> BEST_SR = Comparator.comparing(IPLBatting::getStrikeRate).reversed();
	public static final Comparator<IPLBatting> MOST_SIXES = Comparator.comparing(IPLBatting::getSixes).reversed();
	public static final Comparator<IPLBatting> MOST_FOURS = Comparator.comparing(IPLBatting::getFours).reversed();
	public static final Comparator<Object> MOST_BOUNDARY_RUN_SCORER = Comparator
			.comparing(b -> (((IPLBatting) b).getSixes() * 6 + ((IPLBatting) b).getFours() * 4)).reversed();
	public static final Comparator<Object> MAX_SR_WITH_MOST_6s4s = MOST_BOUNDARY_RUN_SCORER
			.thenComparing(Comparator.comparing(b -> ((IPLBatting) b).getStrikeRate()));
	public static final Comparator<IPLBatting> MAX_RUNS_BEST_SR = Comparator.comparing(IPLBatting::getRuns)
			.thenComparing(Comparator.comparing(IPLBatting::getStrikeRate)).reversed();
	public static final Comparator<Object> BEST_AVG_WITH_BEST_SR = BEST_BATTING_AVG
			.thenComparing(Comparator.comparing(b -> ((IPLBatting) b).getStrikeRate()));
	public static final Comparator<IPLBatting> MOST_HUNDREDS_WITH_BEST_AVG = Comparator
			.comparing(IPLBatting::getCentury).reversed().thenComparing(BEST_BATTING_AVG);
	public static final Comparator<Object> BEST_AVG_WITH_ZERO_100s_50s = Comparator.comparing(b -> {
		if (((IPLBatting) b).getCentury() + ((IPLBatting) b).getHalfCentury() == 0)
			return Double.parseDouble(((IPLBatting) b).getAverage());
		else return 0.0;
	}).reversed();

	/* Bowling data sorting comparators */
	public static final Comparator<IPLBowling> BEST_BOWLING_AVG = Comparator
			.comparing(b -> Double.parseDouble(b.getAverage()));
	public static final Comparator<IPLBowling> BEST_BOWLING_SR = Comparator
			.comparing(b -> Double.parseDouble(b.getStrikeRate()));
	public static final Comparator<IPLBowling> BEST_ECONOMY_BOWLER = Comparator.comparing(IPLBowling::getEconomy);
	public static final Comparator<IPLBowling> BEST_SR_WITH_5W4W = Comparator
			.comparing(IPLBowling::getFourAndFiveWickets).reversed().thenComparing(BEST_BOWLING_SR);
	public static final Comparator<IPLBowling> BEST_BOWLING_AVG_WITH_BEST_SR = BEST_BOWLING_SR
			.thenComparing(BEST_BOWLING_AVG);
	public static final Comparator<IPLBowling> MAX_WKTS_WITH_BEST_BOWLING_AVG = Comparator
			.comparing(IPLBowling::getWickets).reversed().thenComparing(BEST_BOWLING_AVG);

	/* All-rounder data sorting comparators */
	public static final Comparator<IPLAllRounder> BEST_BATTING_AND_BOWLING_AVG = Comparator
			.comparing(IPLAllRounder::getPerformanceByAverage).reversed();
	public static final Comparator<IPLAllRounder> BEST_ALLROUNDER = Comparator
			.comparing(IPLAllRounder::getPerformanceByRunsAndWickets).reversed();

}
