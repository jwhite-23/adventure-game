package AdventureGame;

import java.util.Random;
import java.util.Scanner;

public class AdventureGameApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random randomNum = new Random();
		
		Enemy enemy = new Enemy();
		PlayerOne player = new PlayerOne();
		
		
		String[] enemies = enemy.getEnemies();
		int maxEnemyHealth = enemy.getMaxEnemyHealth();
		int maxEnemyAttackDamage = enemy.getMaxEnemyAttackDamage();
		
		int health = player.getHealth();
		int attackDamage = player.getAttackDamage();
		int healthPotions = player.getHealthPotions();
		int healthPotionHealAmount = player.getHealthPotionHealAmount();
		int healthPotionDropChance = player.getHealthPotionDropChance(); //percentage chance enemy will drop health potion
		
		boolean running = true;
		
		System.out.println("Superman, Metropolis needs your help!");
		
		GAME:
		while(running) {
			System.out.println("-------------------------------------------");
			
			int enemyHealth = randomNum.nextInt(maxEnemyHealth);
			String currentEnemy = enemies[randomNum.nextInt(enemies.length)];
			System.out.println("\t# " + currentEnemy + " has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + currentEnemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Soak up the Sun's healing rays");
				System.out.println("\t3. Fly away!");
				
				String input = in.nextLine();
				
				if(input.equals("1")) {
					int damageDealt = randomNum.nextInt(attackDamage);
					int damageTaken = randomNum.nextInt(maxEnemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike " + currentEnemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You receive " + damageTaken + " in retaliation!");
					
					if(health < 1) {
						System.out.println("\t> You barely get out of Metropolis alive, weak from battle.");
						break;
					}
				} else if (input.equals("2")) {
					if(healthPotions > 0) {
						health += healthPotionHealAmount;
						healthPotions--;
						System.out.println("\t> You soak in the Sun's healing rays, healing yourself for " + healthPotionHealAmount + "."
								+ "\n\t> You now have " + health + " HP."
								+ "\n\t> You have " + healthPotions + " Sun rays left.\n");
					} else {
						System.out.println("\t> You have no Sun rays left! Defeat enemies for a chance to pickup more.");
					}
					
				} else if (input.equals("3")) {
					System.out.println("\tYou fly away from the " + currentEnemy + "!");
					continue GAME;
				} else {
					System.out.println("\tInvalid command! Try again");
				}
			}
			
			if(health < 0) {
				System.out.println("\t> You have taken too much damage, you are too weak to go on. Retreat to the Fortress of Solitude!");
				break;
			}
			int enemyCounter = 1;
			System.out.println("-------------------------------------------");
			System.out.println(" # " + currentEnemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP left. #");
			enemyCounter++;
			if(randomNum.nextInt(100) < healthPotionDropChance) {
				healthPotions++;
				System.out.println(" # " + currentEnemy + " dropped a Sun ray! # ");
				System.out.println(" # You now have " + healthPotions + " Sun ray(s). # ");
			}
			System.out.println("-------------------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Leave Metropolis");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid command!");
				input = in.nextLine();
			}
			
			if(input.equals("1")) {
				System.out.println("You continue on your adventure!");
			} else if(input.equals("2")) {
				System.out.println("Number of enemies defeated: " + enemyCounter);
				System.out.println("Thank you Superman, you saved the day!");
				break;
			}
		}
		
		System.out.println("#####################");
		System.out.println("#THANKS FOR PLAYING!#");
		System.out.println("#####################");
	}

}
