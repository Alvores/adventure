package com.bms.adventure.equiptment;

/**
 * The Item class represents the basic properties of an item.
 * @author Gabriel Zingle
 */
public class Item {
	private double weight; // Weight in lbs
	private int cost; // Gold coins
	private String id; // Unique item ID
	
	public Item(double weight, int cost, String id) {
		
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

}
