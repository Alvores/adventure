package com.bms.adventure.equiptment;

import java.util.ArrayList;

/**
 * The Inventory class holds an assortment of items that belong to a character.
 * @author Gabriel Zingle
 */
public class Inventory {
	// Equipped
	private Item chestSlot;
	private Item leftHand;
	private Item rightHand;
	
	// Backpack
	private ArrayList<Item> weapons;
	private ArrayList<Item> armors;
	private int weight; // Combined weight of items in the inventory
	private int goldCoins; // Total wealth
	
	public Inventory () {
		// Initialize backpack;
		weapons = new ArrayList<>();
		armors = new ArrayList<>();
		setWeight(0);
		setGoldCoins(0);
		chestSlot = null;
		leftHand = null;
		rightHand = null;
	}
	
	public void equipChestSlot(Item item) {
		if (item != null && armors.contains(item)) {
			chestSlot = item;
		}
	}

	public void equipLeftHand(Item item) {
		if (item != null && (weapons.contains(item) || armors.contains(item))) {
			leftHand = item;
		}
	}

	public void equipRightHand(Item item) {
		if (item != null && (weapons.contains(item) || armors.contains(item))) {
			rightHand = item;
		}
	}
	
	// Getters and setters for Inventory properties
	public ArrayList<Item> getWeapons() {
		return weapons;
	}
	public void addWeapon(Weapon weapon) {
		weapons.add(weapon);
		weight += weapon.getWeight();
	}
	public ArrayList<Item> getArmor() {
		return armors;
	}
	private void addArmor(Armor armor) {
		armors.add(armor);
		weight += armor.getWeight();
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
