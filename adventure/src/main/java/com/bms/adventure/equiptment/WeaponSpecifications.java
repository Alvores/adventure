package com.bms.adventure.equiptment;

/**
 * The WeaponSpecifications class contains the details of a weapon such as
 * the damage and critical modifiers of the weapon.
 * @author Gabriel Zingle
 */
public class WeaponSpecifications extends Item {
	
	// Defines weapon properties
	private int ndice; // Number of dice
	private int nsides; // Type of dice
	private int critThreshold; // Dice roll that enables critical strike
	private int critMultiplier; // Critical damage multiplier
	private int attackRange; // Range in meters
	private String fundamentalType; // Melee or ranged
	
	public WeaponSpecifications (String name, int ndice, int nsides, int critThreshold, int critMultiplier, 
			int attackRange, String fundamentalType, double weight, int cost, String id) {
		super(name, weight, cost, id);
		setNdice(ndice);
		setNsides(nsides);
		setCritThreshold(critThreshold);
		setCritMultiplier(critMultiplier);
		setAttackRange(attackRange);
		setFundamentalType(fundamentalType);
	}
	
	// Standard getters and setters for weapon properties
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

}
