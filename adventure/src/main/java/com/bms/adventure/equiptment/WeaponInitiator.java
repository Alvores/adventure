package com.bms.adventure.equiptment;

import java.util.HashMap;
import java.util.Properties;

import com.bms.adventure.utils.PropertyLoader;

public class WeaponInitiator {
	
	// Define the types of weapons
	private static final String LONGSWORD = "longsword";
	private static final String DAGGER = "dagger";
	private static final String STAFF = "staff";
	private static final String RAPIER = "rapier";
	private static final String WARHAMMER = "warhammer";
	private static final String MACE = "mace";
	private static final String BOW = "bow";
	
	// Initialization properties
	private static String id; // Gives id enabling inventory to hold multiples items of same effective type
	private static HashMap<String, WeaponSpecifications> weapons; // Weapons list
	
	// Temporary method for testing purposes
	public static void main(String[] args) {
		
	}
	
	private WeaponInitiator() {} // Not used
	
	public static WeaponSpecifications retrieveWeapon(String weapon) {
		if (weapons == null) {
			loadWeapons();
		}
		return weapons.get(weapon);
	}
	
	private static HashMap<String, WeaponSpecifications> loadWeapons() {
		// Make Properties package/classes/files
		Properties props = PropertyLoader.getProperties();
		String weapon_source = props.getProperty("weapon_source");
		
		// Make conditional if on weapon_source later for loading
		loadHardCodedWeapons();
		return weapons;
	}
	
	private static void loadHardCodedWeapons() {
		weapons = new HashMap<>();
//		Weapon Format: name, ndice, nsides, critThreshold, critMultiplier, attackRange, weight, cost
		weapons.put(WeaponInitiator.LONGSWORD,
				new WeaponSpecifications(WeaponInitiator.LONGSWORD, 1, 8, 19, 2, 1, 4, 15));
		weapons.put(WeaponInitiator.DAGGER,
				new WeaponSpecifications(WeaponInitiator.DAGGER, 1, 4, 19, 2, 1, 1, 2));
		weapons.put(WeaponInitiator.STAFF,
				new WeaponSpecifications(WeaponInitiator.STAFF, 1, 8, 20, 2, 1, 4, 1));
		weapons.put(WeaponInitiator.RAPIER,
				new WeaponSpecifications(WeaponInitiator.RAPIER, 1, 6, 18, 2, 1, 2, 20));
		weapons.put(WeaponInitiator.WARHAMMER,
				new WeaponSpecifications(WeaponInitiator.WARHAMMER, 1, 8, 20, 3, 1, 5, 12));
		weapons.put(WeaponInitiator.MACE, // Heavy Mace, One Handed
				new WeaponSpecifications(WeaponInitiator.MACE, 1, 8, 20, 2, 1, 8, 12));
		weapons.put(WeaponInitiator.BOW,
				new WeaponSpecifications(WeaponInitiator.BOW, 1, 8, 20, 3, 100, 3, 75));
	}

}
