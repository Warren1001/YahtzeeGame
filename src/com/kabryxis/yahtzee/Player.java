package com.kabryxis.yahtzee;

import com.kabryxis.yahtzee.scoring.Category;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Player {
	
	private final Map<Category, Integer> scores = new EnumMap<>(Category.class);
	private final List<Category> unusedCategories = Arrays.asList(Category.values());

}
