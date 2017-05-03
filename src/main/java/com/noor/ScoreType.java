package com.noor;

public enum ScoreType {

    STRIKE(10, "strike", 1), SPARE(10, "spare", 2), NO_BONUS(0, "no_bonus", 2), FOUL(0, "foul", 2);

    private int bonus, chances;
    private String name;

    ScoreType(int bonus, String name, int chances) {
	this.bonus = bonus;
	this.name = name;
	this.chances = chances;
    }

    public int getBonus() {
	return bonus;
    }

    public int getChances() {
	return chances;
    }

    public String getName() {
	return name;
    }

}
