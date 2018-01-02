package com.bms.adventure.equiptment;

/**
 * The Armor class represents the various armors and their relevant properties
 * such as armor class.
 * @author Gabriel Zingle
 */
public class Armor {
	
	// Defines armor properties
	private String armorType; // Type of platemail, chainmail, leather, or cloth
	private int ac; // Armor bonus
	private int modifier; // ac modifier enchant
	private String armorSlot; // Helmet, chest, boots, etc...
	private double weight; // Weight in lbs
	private int cost; // Gold coins
	private String id; // Unique item ID
	private boolean equipped; // Deafult false
	
	
	// Armor functionality
	public Armor(String armorType, int ac, int modifier, 
			String armorSlot, double weight, int cost) {
		setArmorType(armorType);
		setAc(ac);
		setModifier(modifier);
		setArmorSlot(armorSlot);
		setWeight(weight);
		setCost(cost);
		setID(id);
		setEquipped(false);
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public boolean isEquipped() {
		return equipped;
	}
	public void setEquipped(boolean equipped) {
		this.equipped = equipped;
	}

}
