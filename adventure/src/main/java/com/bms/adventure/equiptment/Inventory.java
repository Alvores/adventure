package com.bms.adventure.equiptment;

import java.util.ArrayList;

/**
 * The Inventory class holds an assortment of items that belong to a character.
 * @author Gabriel Zingle
 */
public class Inventory {
	// Equipped
	private Armor armor;
	private Weapon weapon;
	
	// Backpack
	private ArrayList<Weapon> weapons;
	private ArrayList<Armor> armors;
	private int weight; // Combined weight of items in the inventory
	private int goldCoins; // Total wealth
	
	public Inventory (String charClass) {
		// Initialize backpack;
		weapons = new ArrayList<>();
		armors = new ArrayList<>();
		setWeight(0);
		setGoldCoins(0);
		initialGear(charClass);
	}
	
	private void initialGear(String charClass) {
		switch (charClass) {
		case "Fighter":
			armor = ArmorFactory.getArmor("chainmail"); 
			weapon = WeaponFactory.getWeapon("longsword");
			break;
		}
	}
	
	public void equipArmor(Armor item) {
		if (item != null && armors.contains(item)) {
			armor = item;
		}
	}

	public void equipWeapon(Weapon item) {
		if (item != null && weapons.contains(item)) {
			weapon = item;
		}
	}
	
	// Getters and setters for Inventory properties
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void addWeapon(Weapon weapon) {
		weapons.add(weapon);
		weight += weapon.getWeaponSpecifications().getWeight();
	}
	
	public Armor getArmor() {
		return armor;
	}
	
	public void addArmor(Armor armor) {
		armors.add(armor);
		weight += armor.getArmorSpecifications().getWeight();
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getGoldCoins() {
		return goldCoins;
	}
	
	public void setGoldCoins(int goldCoins) {
		this.goldCoins = goldCoins;
	}

}
