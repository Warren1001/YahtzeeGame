package com.kabryxis.yahtzee;

import java.util.Random;

public class DiceRoll {
	
	private final Random random = new Random();
	
	private int d1, d2, d3, d4, d5;
	
	public void roll(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
		if(r1) d1 = random.nextInt(6) + 1;
		if(r2) d2 = random.nextInt(6) + 1;
		if(r3) d3 = random.nextInt(6) + 1;
		if(r4) d4 = random.nextInt(6) + 1;
		if(r5) d5 = random.nextInt(6) + 1;
	}
	
	public void roll() {
		roll(true, true, true, true, true);
	}
	
	public int count(int num) {
		int count = 0;
		if(num == d1) count++;
		if(num == d2) count++;
		if(num == d3) count++;
		if(num == d4) count++;
		if(num == d5) count++;
		return count;
	}
	
	public boolean isYahtzee() {
		return d1 == d2 && d2 == d3 && d3 == d4 && d4 == d5;
	}
	
	public int sum() {
		return d1 + d2 + d3 + d4 + d5;
	}
	
	public boolean isOfAKind(int amount) {
		for (int i = 1; i <= 6; i++) {
			if(count(i) >= amount) return true;
		}
		return false;
	}
	
	public boolean isFullHouse() {
		for (int i = 1; i <= 6; i++) {
			if (count(i) == 3) {
				for (int j = 1; j <= 6; j++) {
					if (i != j && count(j) == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isStraight(int amount) {
		int shifts = 6 - amount;
		for (int shift = 0; shift < shifts; shift++) {
			boolean isSequence = true;
			for (int check = 1; check <= amount; check++) {
				int count = count(check + shift);
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
