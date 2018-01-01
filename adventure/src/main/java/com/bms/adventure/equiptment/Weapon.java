package com.bms.adventure.equiptment;

import com.bms.adventure.utils.Dice;

/**
 * The Weapons class represents the various weapons and their relevant properties
 * including damage, range, and critical strike properties.
 * @author Gabriel Zingle
 */
public class Weapon {
	
	// Defines the types of weapons
	private static final String longSword = "Longsword";
	private static final String dagger = "Dagger";
	private static final String staff = "Staff";
	private static final String bow = "Bow";
	
	// Defines weapon properties
	private String weaponType; // Type of sword, axe, bow, etc...
	private int ndice; // Number of dice
	private int nsides; // Type of dice
	private int critThreshold; // Dice roll that enables critical strike
	private int critMultiplier; // Critical damage multiplier
	private int attackRange; // Range in meters
	private int modifier; // Damage and hit chance modifier
	private String fundamentalType; // Melee or ranged
	private double weight; // Weight in lbs
	private int cost; // Gold coins
	
	public Weapon (String weaponType, int ndice, int nsides, int critThreshold, int critMultiplier, 
			int attackRange, String fundamentalType, double weight, int cost) {
		setWeaponType(weaponType);
		setNdice(ndice);
		setNsides(nsides);
		setCritThreshold(critThreshold);
		setCritMultiplier(critMultiplier);
		setAttackRange(attackRange);
		setFundamentalType(fundamentalType);
		setWeight(weight);
		setCost(cost);
	}
	
	// Weapon functionality
	public int rollDamage() {
		return Dice.rollDice(ndice, nsides, modifier); // Roll damage
	}
	
	public int attackRoll() {
		return Dice.rollDice(1, 20, modifier); // Roll to hit target
	}
	
	// Standard getters and setters for properties
	public String getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	public int getNdice() {
		return ndice;
	}
	public void setNdice(int ndice) {
		this.ndice = ndice;
	}
	public int getNsides() {
		return nsides;
	}
	public void setNsides(int nsides) {
		this.nsides = nsides;
	}
	public int getCritThreshold() {
		return critThreshold;
	}
	public void setCritThreshold(int critThreshold) {
		this.critThreshold = critThreshold;
	}
	public int getCritMultiplier() {
		return critMultiplier;
	}
	public void setCritMultiplier(int critMultiplier) {
		this.critMultiplier = critMultiplier;
	}
	public int getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	public String getFundamentalType() {
		return fundamentalType;
	}
	public void setFundamentalType(String fundamentalType) {
		this.fundamentalType = fundamentalType;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
