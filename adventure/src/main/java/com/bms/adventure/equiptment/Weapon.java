package com.bms.adventure.equiptment;

import com.bms.adventure.utils.Dice;

/**
 * The Weapons class represents the various weapons and their relevant properties
 * including damage, range, and critical strike properties.
 * @author Gabriel Zingle
 */
public class Weapon {
	
	// Defines weapon properties
	private String description;
	private int enhancementBonus; // Magical damage and hit chance modifier
	private WeaponSpecifications weaponSpecifications; // Holds details such as damage and critical properties
	private static final String slot = "HAND_WEAPON";
	
	public Weapon (String description, int enhancementBonus, WeaponSpecifications weaponSpecifications) {
		setDescription(description);
		setEnhancementBonus(enhancementBonus);
		setWeaponSpecifications(weaponSpecifications);
	}
	
	// Weapon functionality
	public int rollDamage() {
		int ndice = weaponSpecifications.getNdice();
		int nsides = weaponSpecifications.getNsides();
		return Dice.rollDice(ndice, nsides, enhancementBonus); // Roll damage
	}
	
	public int attackRoll() {
		return Dice.rollDice(1, 20, enhancementBonus); // Roll to hit target
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnhancementBonus() {
		return enhancementBonus;
	}

	public void setEnhancementBonus(int enhancementBonus) {
		this.enhancementBonus = enhancementBonus;
	}

	public WeaponSpecifications getWeaponSpecifications() {
		return weaponSpecifications;
	}

	public void setWeaponSpecifications(WeaponSpecifications weaponSpecifications) {
		this.weaponSpecifications = weaponSpecifications;
	}
	
}
