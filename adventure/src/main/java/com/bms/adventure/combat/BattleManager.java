package com.bms.adventure.combat;

import com.bms.adventure.characters.PlayerCharacter;
import com.bms.adventure.utils.Dice;

/**
 * Handles turn based combat among players and adversaries.
 * @author Gabriel Zingle
 */
public class BattleManager {
	
	private PlayerCharacter player;
	private PlayerCharacter opponent; // Can change into ArrayList for multiple combatants
	
	public BattleManager (PlayerCharacter player, PlayerCharacter opponent) {
		this.player = player;
		this.opponent = opponent;
		battle();
	}
	
	public void battle() {
		System.out.println("The combatants are:");
		System.out.println(player.styledToString());
		System.out.println(opponent.styledToString());
		int round = 1;
		boolean fighting = true;
		int playerInitiative;
		int opponentInitiative;
		
		while (fighting) {
			System.out.println("Round " + round + ": ");
			// Calculate initiative and allot turns to combatants
			playerInitiative = Dice.rollDice(1, 20, (player.getDexterity() - 10) / 2);
			opponentInitiative = Dice.rollDice(1, 20, (player.getDexterity() - 10) / 2);
			System.out.println(player.getName() + " initiative: " + playerInitiative);
			System.out.println(opponent.getName() + " initiative: " + opponentInitiative);
			if (playerInitiative > opponentInitiative) {
				fighting  = turn(player, opponent);
				if (!fighting) break;
				fighting = turn(opponent, player);
			} else if (opponentInitiative > playerInitiative) {
				fighting = turn(opponent, player);
				if (!fighting) break;
				fighting  = turn(player, opponent);
			}
			if (!fighting) break;
			round++; // End round
		}
	}
	
	public boolean turn(PlayerCharacter attacker, PlayerCharacter defender) {
		if (player.getCurrentHp() <= 0 || opponent.getCurrentHp() <= 0) {
			return false;
		}
		attackTarget(attacker, defender);
		System.out.println(attacker.getName() + " has " + attacker.getCurrentHp() + 
				" and " + defender.getName() + " has " + defender.getCurrentHp());
		if (attacker.getCharClass().equals("Rogue")) { // Attack with second dagger
			attackTarget(attacker, defender);
			System.out.println(attacker.getName() + " has " + attacker.getCurrentHp() + 
					" and " + defender.getName() + " has " + defender.getCurrentHp());
		}
		return true;
	}
	
	public void attackTarget(PlayerCharacter attacker, PlayerCharacter defender) {
		boolean crit = false;
		// Check for natural critical or miss
		int roll = Dice.rollDice(1, 20);
		// Check hit
		if (roll == 20) { // Natural 20
			System.out.println(attacker.getName() + " hits " + defender.getName() + " with a roll of 20.");
		} else if (roll == 1) { // Natural miss
			System.out.println(attacker.getName() + " misses "+ defender.getName() + " with a roll of 1.");
		} else { // Check total hit roll against defenders armor class
			roll += attacker.attackRollBonus();
			if (roll < defender.getAc()) {
				System.out.println(attacker.getName() + " misses " + 
						defender.getName() + " with a roll of " + roll);
				return;
			} 
		}
		System.out.println(attacker.getName() + " hits " + defender.getName() + " with a roll of " + roll);
		// Check crit if applicable
		int critThreshold = attacker.getInventory().getWeapon().getWeaponSpecifications().getCritThreshold();
		if (roll >= critThreshold) {
			roll = Dice.rollDice(1, 20);
			if (roll < defender.getAc()) {
				System.out.println(attacker.getName() + " has critically hit " + defender.getName() + "!");
				crit = true;
			}
		}
		// Roll for damage if applicable
		int damage = attacker.damageRollTotal();
		if (crit) {
			int critMultiplier = attacker.getInventory().getWeapon().getWeaponSpecifications().getCritMultiplier();
			damage *= critMultiplier;
		}
		System.out.println(attacker.getName() + " has dealt " + damage + " to " + defender.getName());
		defender.setCurrentHp(defender.getCurrentHp()-damage);
	}

}
