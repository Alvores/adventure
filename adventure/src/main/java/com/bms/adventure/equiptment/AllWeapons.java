package com.bms.adventure.equiptment;

import java.util.HashMap;

public class AllWeapons {
	
	// Define the types of weapons
//	private static final Weapon longSword = 
//			new Weapon("Longsword", 1, 8, 19, 2, 1, "Melee", 25, 30);
//	private static final Weapon dagger =
//			new Weapon("Dagger", 1, 4, 20, 2, 1, "Melee", 10, 12);
//	private static final Weapon staff =
//			new Weapon("Staff", 1, 6, 20, 2, 1, "Melee", 30, 20);
//	private static final Weapon bow =
//			new Weapon("Bow", 1, 8, 19, 2, 30, "Range", 25, 40);
	
	private static String id; // Gives id enabling inventory to hold multiples items of same effective type
	
	// Weapons list
	private static HashMap<String, Weapon> weapons = new HashMap<>();
	
	public HashMap<String, Weapon> retrieveWeapons() {
		return weapons;
	}

}
