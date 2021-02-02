package com.kabryxis.yahtzee;

import com.kabryxis.yahtzee.scoring.*;

public class Yahtzee {
	
	public static final ScoringCategory ACES   = new CombinationCategory(1);
	public static final ScoringCategory TWOS   = new CombinationCategory(2);
	public static final ScoringCategory THREES = new CombinationCategory(3);
	public static final ScoringCategory FOURS  = new CombinationCategory(4);
	public static final ScoringCategory FIVES  = new CombinationCategory(5);
	public static final ScoringCategory SIXES  = new CombinationCategory(6);
	public static final ScoringCategory THREE_OF_A_KIND = new OfAKindCategory(3);
	public static final ScoringCategory FOUR_OF_A_KIND = new OfAKindCategory(4);
	public static final ScoringCategory FULL_HOUSE = new FullHouseCategory();
	public static final ScoringCategory SMALL_STRAIGHT = new StraightCategory(true);
	public static final ScoringCategory LARGE_STRAIGHT = new StraightCategory(false);
	public static final ScoringCategory YAHTZEE = new YahtzeeCategory();
	public static final ScoringCategory CHANCE = new ChanceCategory();
	
	public static void main(String[] args) {
	
	}
	
}
