package com.bms.adventure.characters;

import com.bms.adventure.utils.Dice;
import com.bms.adventure.characters.*;

public class PlayerCharacter {
	
	private String name;
	private String charClass;
	private int hp; // Hit Points
	private int xp;	// Experience Points
	private int strength;
	private int intellect;
	private int wisdom;
	private int dexterity;
	private int charisma;
	private int constitution;
	private double bab;
	private double fortitude;
	private double will;
	private double reflex;
	private String faction;

	private PlayerCharacter() {
	};

	public static PlayerCharacter makeNewPlayerCharacter(String name, String charClass) {
		PlayerCharacter pc = new PlayerCharacter();
		pc.setName(name);
		pc.setCharClass(charClass);
		pc = Dice.allocateAbilityScores(3, 6, pc);
		pc.setFaction("Heroes");
		pc.setFortitude(1);
		pc.setWill(1);
		pc.setReflex(1);
		return pc;
	}
	
	public void levelUp() {
		//hp += CharacterClass.get
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getCharClass() {
		return charClass;
	}

	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
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

	// TODO override toString() to print out the PlayerCharacter nicely
	public String toString() {
		return "Name: " + name + "\nClass: " + charClass + "\nHP: " + hp 
				+ "\nXP: " + xp + "\nStrength: " 
				+ strength + "\nIntellect: " + intellect
				+ "\nWisdom: " + wisdom + "\nDexterity: " + dexterity
				+ "\nCharisma: " + charisma + "\nConstitution: " + constitution
				+ "\nBAB: " + (int)bab + "\nSaves (Fort/Will/Reflex): " 
				+ (int)fortitude + "/" + (int)will + "/" + (int)reflex 
				+ "\nFaction: " + faction;
	}
}
