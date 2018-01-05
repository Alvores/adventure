package com.bms.adventure.equiptment;

import java.util.HashMap;
import java.util.Properties;

import com.bms.adventure.utils.PropertyLoader;

/**
 * Loads basic armor molds into a map for retrieval by a factory class.
 * @author Gabriel Zingle
 */
public class ArmorInitiator {

	// Define the types of armor
	private static final String PLATEMAIL = "platemail";
	private static final String CHAINMAIL = "chainmail";
	private static final String LEATHER = "leather";
	private static final String CLOTH = "cloth";
	
	
	// Initialization properties
	private static HashMap<String, ArmorSpecifications> armors; // Weapons list

	// Temporary method for testing purposes
	public static void main(String[] args) {

	}

	private ArmorInitiator() {} // Not used
	
	public static ArmorSpecifications retrieveArmor(String armor) {
		if (armors == null) {
			loadArmors();
		}
		return armors.get(armor);
	}
	
	private static HashMap<String, ArmorSpecifications> loadArmors() {
		// Make Properties package/classes/files
		Properties props = PropertyLoader.getProperties();
		String armor_source = props.getProperty("armor_source");
		
		// Make conditional if on armor_source later for loading
		loadHardCodedArmors();
		return armors;
	}
	
	private static void loadHardCodedArmors() {
		armors = new HashMap<>();
//		Armor Format: name, ac, maxDexBonus, weight, cost
		armors.put(ArmorInitiator.PLATEMAIL, // Half Plate
				new ArmorSpecifications(ArmorInitiator.PLATEMAIL, 7, 0, 50, 600));
		armors.put(ArmorInitiator.CHAINMAIL, 
				new ArmorSpecifications(ArmorInitiator.CHAINMAIL, 5, 2, 40, 150));
		armors.put(ArmorInitiator.LEATHER, 
				new ArmorSpecifications(ArmorInitiator.LEATHER, 2, 6, 15, 10));
		armors.put(ArmorInitiator.CLOTH, 
				new ArmorSpecifications(ArmorInitiator.CLOTH, 0, 100, 5, 5));
	}
	
}
