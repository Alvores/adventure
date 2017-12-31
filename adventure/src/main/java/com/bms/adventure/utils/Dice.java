package com.bms.adventure.utils;

import java.util.Arrays;
import java.util.Random;
import com.bms.adventure.characters.PlayerCharacter;

/**
 * Here we will create a Dice rolling class with methods that take the number of dice to roll
 * and which dice-type we are rolling (the number of sides). 
 * 
 * We'll create an array dice[] to temporarily store each roll so that we can print them out for debugging purposes
 */
public class Dice {
	
	private static boolean DEBUG = false; // Currently provides empty matrix
	private static int[] abilityScores = new int[6];
	
	public static int rollDice(int ndice, int nsides) {
		return rollDice(ndice, nsides, 0);
	}
	
	// Sum of dice roll generated through given dice type, dice quantity, and modifier
	public static int rollDice(int ndice, int nsides, int modifier) {
		int[] dice = new int[ndice];
		int sum = 0;
		int randNum;
		randNum = randomNum(nsides);
		for (int i = 0; i < ndice; i++) {
			randNum = randomNum(nsides);
			dice[i] = randNum;
			sum+=randNum;	
		}
		// TODO roll the dice!
		if(DEBUG) {
			System.out.println(getIntArrayAsString(dice));
		}
		return sum + modifier;
	}
	
	// Fills array with ability scores
	public static PlayerCharacter allocateAbilityScores (int ndice, int nsides, PlayerCharacter pc) {
		for (int i = 0; i < abilityScores.length; i++) {
			abilityScores[i] = rollAbilityScoreDice(ndice, nsides);
		}
		sortArray();
		switch (pc.getCharClass()) {	// Ability scores equal set spot in array
		case "Fighter": 
			swapValues(4,5);
			swapValues(1, 5);
			break;
		case "Wizard": 
			swapValues(3,5);
			swapValues(1, 4);
			break;
		case "Rogue":
			swapValues(2,5);
			swapValues(1, 4);
			break;
		}
		return abilityScorePreference(pc); // Organizes and finalizes ability scores
	}
	
	private static PlayerCharacter abilityScorePreference (PlayerCharacter pc) {
		pc.setCharisma(abilityScores[0]);
		pc.setConstitution(abilityScores[1]);	// Default 2nd priority
		pc.setDexterity(abilityScores[2]);	// Rogue priority
		pc.setIntellect(abilityScores[3]);	// Wizard priority
		pc.setStrength(abilityScores[4]);	// Fighter priority
		pc.setWisdom(abilityScores[5]);
		return pc;
	}
	
	//Swaps place of values in array
	private static void swapValues (int val1, int val2) {
		int temp = abilityScores[val1];
		abilityScores[val1] = abilityScores[val2];
		abilityScores[val2] = temp;
	}
	
	// Ability scores generated as 3d6 excluding roles of value 1
	private static int rollAbilityScoreDice(int ndice, int nsides) {
		int[] dice = new int[ndice];
		int sum = 0;
		int randNum;
		randNum = randomNum(nsides);
		for (int i = 0; i < ndice; i++) {
			randNum = randomNum(nsides);
			while (randNum == 1) {
				randNum = randomNum(nsides);
			}
			dice[i] = randNum;
			sum+=randNum;	
		}
		// TODO roll the dice! For ability scores we will re-roll all ones
		
		if(DEBUG) {
			System.out.println(getIntArrayAsString(dice));
		}
		return sum;
	}
	
	public static String getIntArrayAsString(int[] a) {
		StringBuffer buff = new StringBuffer();
		int sum = 0;
		for (int i=0; i<a.length; i++) {
			sum += a[i];
			if (i==0) {
				if (a.length==1) {
					buff.append("Dice rolls: [" + a[i] + "]");
				} else {
					buff.append("Dice rolls: [" + a[i] + " ");
				}
			} else if (i==a.length-1) {
				buff.append(a[i]+"]");
			} else {
				buff.append(a[i] + " ");
			}
		}
		return buff.toString() + " " + sum;
	}
	
	// Generates a random number within and including the high-low range
	private static int randomNum(int high) {
		Random rand = new Random();
		int randGen = rand.nextInt(high)+1;
		return randGen;	
	}
	
	// Sorts array (a method collaborator for rollAbilityScoreDice) from least to greatest
	// Utilizes bubble sort
	private static void sortArray () {
		for (int i = abilityScores.length-1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (abilityScores[j] > abilityScores[j+1]) {
					swapValues(j, j+1);
				}
			}
		}
	}

}
