package com.bms.adventure.equiptment;

import java.util.HashMap;

/**
 * The Inventory class holds an assortment of items that belong to a character.
 * @author Gabriel Zingle
 */
public class Inventory {
	
	private HashMap<String, Weapon> weapons;
	private HashMap<String, Armor> armor;
	private int weight; // Combined weight of items in the inventory
	private int goldCoins; // Total wealth
	
	public Inventory () {
		weapons = new HashMap<>();
		armor = new HashMap<>();
		setWeight(0);
		setGoldCoins(0);
	}
	
	// Getters and setters for Inventory properties
	public HashMap<String, Weapon> getWeapons() {
		return weapons;
	}
	public void addWeapon(Weapon weapon) {
		
	}
	public HashMap<String, Armor> getArmor() {
		return armor;
	}
	private void addArmor(Armor armor) {
		
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
