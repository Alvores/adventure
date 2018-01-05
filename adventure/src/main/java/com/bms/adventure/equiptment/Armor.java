package com.bms.adventure.equiptment;

/**
 * The Armor class represents the various armors and their relevant properties
 * such as armor class.
 * @author Gabriel Zingle
 */
public class Armor {
	
	// Defines armor properties
	private String description;
	private int enhancementBonus; // Magical armor modifier
	private static final String slot = "ARMOR";
	private ArmorSpecifications armorSpecifications; // Holds details such as damage and critical properties
		
	// Armor functionality
	public Armor(String description, int enhancementBonus, ArmorSpecifications armorSpecifications) {
		setDescription(description);
		setEnhancementBonus(enhancementBonus);
		setArmorSpecifications(armorSpecifications);
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

	public ArmorSpecifications getArmorSpecifications() {
		return armorSpecifications;
	}

	public void setArmorSpecifications(ArmorSpecifications armorSpecifications) {
		this.armorSpecifications = armorSpecifications;
	}

}
