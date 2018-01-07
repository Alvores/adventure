package com.bms.adventure.equiptment;

/**
 * The ArmorSpecifications class contains the details of a piece of armor
 *  such as the armor class of the piece.
 * @author Gabriel Zingle
 */
public class ArmorSpecifications extends Item {
	
	// Defines armor properties
	private int ac;
	private int maxDexterityAC;
	
	// Armor functionality
	public ArmorSpecifications(String name, int ac, int maxDexterityAC, double weight, int cost) {
		super(name, weight, cost);
		setAc(ac);
		setMaxDexterityAC(maxDexterityAC);
	}
	
	// Standard getters and setters for armor properties
	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
	
	public int getMaxDexterityAC() {
		return maxDexterityAC;
	}
	
	public void setMaxDexterityAC(int maxDexterityAC) {
		this.maxDexterityAC = maxDexterityAC;
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + ac + "," + maxDexterityAC;
	}

}
