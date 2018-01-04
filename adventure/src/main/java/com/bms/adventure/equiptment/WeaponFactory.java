package com.bms.adventure.equiptment;

/**
 * The WeaponFactory class creates objects of a specified weapon.
 * @author Gabriel Zingle
 */
public class WeaponFactory {
	
	public static Weapon getWeapon(String weaponName) {
		return getWeapon(weaponName, "", 0); // Name, Description, enchancement
	}
	
	public static Weapon getWeapon(String weaponName, String description, int enhancement) {
		WeaponSpecifications weaponSpecifications = WeaponInitiator.retrieveWeapon(weaponName);
		Weapon weapon = new Weapon(description, enhancement, weaponSpecifications);
		return weapon;
	}

}
