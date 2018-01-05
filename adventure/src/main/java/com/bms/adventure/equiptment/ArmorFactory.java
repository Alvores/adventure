package com.bms.adventure.equiptment;

/**
 * The ArmorFactory class creates objects of a specified armor piece.
 * @author Gabriel Zingle
 */
public class ArmorFactory {
	
	public static Armor getArmor(String armorName) {
		return getArmor(armorName, "", 0); // Name, Description, enchancement
	}
	
	public static Armor getArmor(String armorName, String description, int enhancement) {
		ArmorSpecifications armorSpecifications = ArmorInitiator.retrieveArmor(armorName);
		Armor armor = new Armor(description, enhancement, armorSpecifications);
		return armor;
	}

}
