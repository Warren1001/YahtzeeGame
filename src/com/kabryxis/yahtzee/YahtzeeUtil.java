package com.kabryxis.yahtzee;

public final class YahtzeeUtil {
	
	private YahtzeeUtil() {}
	
	public static boolean isOfAKind(DiceRoll roll, int amount) {
		for (int i = 1; i <= 6; i++) {
			if(roll.count(i) >= amount) return true;
		}
		return false;
	}
	
	public static boolean isFullHouse(DiceRoll roll) {
		for (int i = 1; i <= 6; i++) {
			if (roll.count(i) == 3) {
				for (int j = 1; j <= 6; j++) {
					if (i != j && roll.count(j) == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isStraight(DiceRoll roll, int amount) {
		int shifts = 6 - amount;
		for (int shift = 0; shift < shifts; shift++) {
			boolean isSequence = true;
			for (int check = 1; check <= amount; check++) {
				int count = roll.count(check + shift);
				if(count == 0 || count > shift) {
					isSequence = false;
					break;
				}
			}
			if (isSequence) return isSequence;
		}
		return false;
	}
	
}
