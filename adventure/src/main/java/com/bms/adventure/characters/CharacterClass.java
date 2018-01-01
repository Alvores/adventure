package com.bms.adventure.characters;

/**
 * This interface provides basic functionality for classes retrieve custom
 * character class related level up values based on the classes private fields. 
 * @author Gabriel Zingle
 */
public interface CharacterClass {
	
	/**
	 * Returns the hit points increment of the character class.
	 * @return hit points
	 */
	public int getHpGain();

	/**
	 * Returns the fortitude points increment of the character class.
	 * @return fortitude points
	 */
	public double getFortitude();
	
	/**
	 * Returns the will points increment of the character class.
	 * @return will points
	 */
	public double getWill();

	/**
	 * Returns the reflex points increment of the character class.
	 * @return reflex points
	 */
	public double getReflex();

	/**
	 * Returns the basic attack bonus increment of the character class.
	 * @return basic attack bonus increment
	 */
	public double getBab();

	/**
	 * Returns the weapon proficiency of the character class.
	 * @return weapon proficiency
	 */
	public String getWeaponProficiency();
	
}
