package com.bms.adventure.characters;

import com.bms.adventure.equiptment.Inventory;
import com.bms.adventure.utils.Dice;

/**
 * The PlayerCharacter class defines a characters profile including
 * hit points, character class, level, and attribute points.
 * @author Gabriel Zingle
 */
public class PlayerCharacter {
	
	private String name;
	private String charClass;
	private int hp; // Hit Points
	private int currentHp; // Accounts for temporary damage and buffs
	private int xp;	// Experience Points
	private int level;
	private int acBonus; // Armor class
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
	private Inventory inventory;

	/**
	 * Private constructor enables construction of character class from a static method call.
	 */
	private PlayerCharacter() {
	}

	/**
	 * Generates a new character with the indicated name and character class.
	 * @param name the name of the character
	 * @param charClass the character class of the character
	 * @return the initiated player character
	 */
	public static PlayerCharacter makeNewPlayerCharacter(String name, String charClass) {
		PlayerCharacter pc = new PlayerCharacter();
		pc.setName(name);
		pc.setCharClass(charClass);
		pc = Dice.allocateAbilityScores(3, 6, pc);
		pc.setFaction("Heroes");
		pc.setFortitude(1.0);
		pc.setWill(1.0);
		pc.setReflex(1.0);
		pc.setBab(1.0); // Initial BAB is 1 for all character classes
		pc.setAc(10);
		pc.levelUp(); // Sets character to level 1, giving appropriate starting scores.
		pc.inventory = new Inventory(charClass);
		return pc;
	}
	
	/**
	 * Levels up the character class with appropriate attributes and abilities.
	 */
	public void levelUp() {
		switch(charClass) {
		case "Fighter":
			Fighter.levelUp(this);
			break;
		case "Rogue":
			Rogue.levelUp(this);
			break;
		case "Wizard":
			Wizard.levelUp(this);
			break;
		}
		level++;
		currentHp = hp;
	}
	
	public int attackRollBonus() {
		int attack = inventory.getWeapon().getEnhancementBonus();
		attack += (getStrength() - 10) / 2;
		return attack;
	}
	
	public int damageRollTotal() {
		int damage = inventory.getWeapon().rollDamage();
		damage += (getStrength() - 10) / 2;
		return damage;
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
	
	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getAc() {
		int bonus = 0;
		int maxDex = inventory.getArmor().getArmorSpecifications().getMaxDexterityAC(); // Max Dexterity Bonus
		int dexBonus = (getDexterity() - 10) / 2;
		if (maxDex < dexBonus) {
			bonus = maxDex;
		} else {
			bonus = dexBonus;
		}
		bonus += inventory.getArmor().getArmorSpecifications().getAc(); // Main armor bonus
		acBonus += bonus;
		return acBonus; // Base 10 + Armor with Dexterity
	}

	public void setAc(int acBonus) {
		this.acBonus = acBonus;
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
	
	public Inventory getInventory() {
		return inventory;
	}

	public String styledToString() {
		return "Name: " + name + "\nClass: " + charClass + "\nHP: " + hp 
				+ "\nCurrent HP: " + currentHp + "\nAC: " + getAc()
				+ "\nLevel: " + level + "\nXP: " + xp + "\nStrength: " 
				+ strength + "\nIntellect: " + intellect
				+ "\nWisdom: " + wisdom + "\nDexterity: " + dexterity
				+ "\nCharisma: " + charisma + "\nConstitution: " + constitution
				+ "\nBAB: " + (int)bab + "\nSaves (Fort/Will/Reflex): " 
				+ (int)fortitude + "/" + (int)will + "/" + (int)reflex 
				+ "\nFaction: " + faction;
	}
	
	@Override
	public String toString() { // Add inventory later
		return name + "," + charClass + "," + hp + "," + currentHp + "," + getAc()  + "," + level
				+ "," + xp + "," + strength + "," + intellect + "," + wisdom + "," + dexterity
				+ "," + charisma + "," + constitution + "," + bab + "," + fortitude
				+ "," + will  + "," + reflex + "," + faction;
	}
}
