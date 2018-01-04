package com.bms.adventure.equiptment;

/**
 * The Item class represents the basic properties of an item.
 * @author Gabriel Zingle
 */
public class Item {
	private String name; // Type of item or special name for noteworthy items
	private double weight; // Weight in lbs
	private int cost; // Gold coins
	private String id; // Unique item ID
	
	public Item(String name, double weight, int cost, String id) {
		setName(name);
		setWeight(weight);
		setCost(cost);
		setID(id);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
