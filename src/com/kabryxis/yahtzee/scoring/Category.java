package com.kabryxis.yahtzee.scoring;

import com.kabryxis.yahtzee.DiceRoll;
import com.kabryxis.yahtzee.YahtzeeUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public enum Category {
	
	ACES(roll -> roll.count(1) > 1, roll -> roll.count(1)),
	TWOS(roll -> roll.count(2) > 1, roll -> roll.count(2) * 2),
	THREES(roll -> roll.count(3) > 1, roll -> roll.count(3) * 3),
	FOURS(roll -> roll.count(4) > 1, roll -> roll.count(4) * 4),
	FIVES(roll -> roll.count(5) > 1, roll -> roll.count(5) * 5),
	SIXES(roll -> roll.count(6) > 1, roll -> roll.count(6) * 6),
	THREE_OF_A_KIND(roll -> YahtzeeUtil.isOfAKind(roll, 3)),
	FOUR_OF_A_KIND(roll -> YahtzeeUtil.isOfAKind(roll, 4)),
	FULL_HOUSE(YahtzeeUtil::isFullHouse, roll -> 25),
	SMALL_STRAIGHT(roll -> YahtzeeUtil.isStraight(roll, 4), roll -> 30),
	LARGE_STRAIGHT(roll -> YahtzeeUtil.isStraight(roll, 5), roll -> 40),
	YAHTZEE(DiceRoll::isYahtzee, roll -> 50),
	CHANCE(roll -> true);
	
	private final Predicate<DiceRoll>         matchesPredicate;
	private final Function<DiceRoll, Integer> calculateScoreFunction;
	
	Category(Predicate<DiceRoll> matchesPredicate, Function<DiceRoll, Integer> calculateScoreFunction) {
		this.matchesPredicate = matchesPredicate;
		this.calculateScoreFunction = calculateScoreFunction;
	}
	
	Category(Predicate<DiceRoll> matchesPredicate) {
		this(matchesPredicate, DiceRoll::sum);
	}
	
	public boolean matches(DiceRoll roll) {
		return matchesPredicate.test(roll);
	}
	
	public int getScore(DiceRoll roll) {
		return calculateScoreFunction.apply(roll);
	}
	
}
