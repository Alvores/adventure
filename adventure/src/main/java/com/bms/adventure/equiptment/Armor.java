package com.bms.adventure.equiptment;

/**
 * The Armor class represents the various armors and their relevant properties
 * such as armor class.
 * @author Gabriel Zingle
 */
public class Armor extends Item {
	
	// Defines armor properties
	private String armorType; // Type of platemail, chainmail, leather, or cloth
	private int ac; // Armor bonus
	private int modifier; // ac modifier enchant
	private String armorSlot; // Helmet, chest, boots, etc...
		
	// Armor functionality
	public Armor(String name, String armorType, int ac, int modifier, 
			String armorSlot, double weight, int cost) {
		super(name, weight, cost);
		setArmorType(armorType);
		setAc(ac);
		setModifier(modifier);
		setArmorSlot(armorSlot);
	}
	
	// Standard getters and setters for armor properties
	public String getArmorType() {
		return armorType;
	}
	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	public int getModifier() {
		return modifier;
	}
	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
	public String getArmorSlot() {
		return armorSlot;
	}
	public void setArmorSlot(String armorSlot) {
		this.armorSlot = armorSlot;
	}

}
