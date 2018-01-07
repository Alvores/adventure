package com.bms.adventure.characters;

/**
 * The Character class represents a basic mold for all creatures.
 * @author Gabriel Zingle
 *
 */
public class Character {
	
	private int hp; // Hit Points
	private int currentHp; // Accounts for temporary damage and buffs
	private int acBonus; // Armor class
	private double bab;
	private double fortitude;
	private double will;
	private double reflex;
	private String faction;
	
	public Character (String faction) {
		setFaction(faction);
		setFortitude(1.0);
		setWill(1.0);
		setReflex(1.0);
		setBab(1.0); // Initial BAB is 1 for all character classes
		setAc(10); // Base armor class
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}
	
	public int getAc() {
		return acBonus;
	}

	public void setAc(int acBonus) {
		this.acBonus = acBonus;
	}

	public double getBab() {
		return bab;
	}

	public void setBab(double bab) {
		this.bab = bab;
	}

	public double getFortitude() {
		return fortitude;
	}

	public void setFortitude(double fortitude) {
		this.fortitude = fortitude;
	}

	public double getWill() {
		return will;
	}

	public void setWill(double will) {
		this.will = will;
	}

	public double getReflex() {
		return reflex;
	}

	public void setReflex(double reflex) {
		this.reflex = reflex;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

}
