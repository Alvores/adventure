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
	}
	
	public void battle() {
		int round = 1;
		boolean fighting = false;
		int playerInitiative;
		int opponentInitiative;
		
		while (fighting) {
			System.out.println("Round " + round + ": ");
			playerInitiative = Dice.rollDice(1, 20, (player.getDexterity() - 10) / 2);
			opponentInitiative = Dice.rollDice(1, 20, (player.getDexterity() - 10) / 2);
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
		if (player.getHp() <= 0 || opponent.getHp() <= 0) {
			return false;
		}
		attackTarget(attacker, defender);
		return true;
	}
	
	public void attackTarget(PlayerCharacter attacker, PlayerCharacter defender) {
		boolean hit = false;
		boolean crit = false;
		// Check for natural critical or miss
		int roll = Dice.rollDice(1, 20);
		// Check hit
		if (roll == 20) { // Natural 20
			hit = true;
		} else if (roll == 1) { // Natural miss
			hit = false;
		} else { // Check total hit roll against defenders armor class
			roll += attacker.attackRollBonus();
			if (roll >= defender.getAc()) {
				hit = true;
			} else {
				hit = false;
			}
		}
		// Check crit if applicable
		int critThreshold = attacker.getInventory().getWeapon().getWeaponSpecifications().getCritThreshold();
		if (roll >= critThreshold) crit = true;
		// Roll for damage if applicable
		int damage = attacker.damageRollTotal();
		if (crit) {
			int critMultiplier = attacker.getInventory().getWeapon().getWeaponSpecifications().getCritMultiplier();
			damage *= critMultiplier;
		}
		defender.setCurrentHp(defender.getCurrentHp()-damage);
	}

}
