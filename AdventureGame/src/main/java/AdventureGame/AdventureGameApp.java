package AdventureGame;

import java.util.Random;
import java.util.Scanner;

public class AdventureGameApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random randomNum = new Random();
		
		
		String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin" };
		int maxEnemyHealth = 100;
		int maxEnemyAttackDamage = 25;
		
		int health = 125;
		int attackDamage = 50;
		int healthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; //percentage chance enemy will drop health potion
		
		boolean running = true;
		
		System.out.println("Welcome to the Dungeon!");
		
		GAME:
		while(running) {
			System.out.println("-------------------------------------------");
			
			int enemyHealth = randomNum.nextInt(maxEnemyHealth);
			String enemy = enemies[randomNum.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " has appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2.Drink health potioon");
				System.out.println("\t3. Run!");
				
				String input = in.nextLine();
				if(input.equals("1")) {
					int damageDealt = randomNum.nextInt(attackDamage);
					int damageTaken = randomNum.nextInt(maxEnemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You receive " + damageTaken + " in retaliation!");
					
					if(health < 1) {
						System.out.println("\t> You have taken too much damage, you are too weak to go on!");
						break;
					}
				} else if (input.equals("2")) {
					if(healthPotions > 0) {
						health += healthPotionHealAmount;
						healthPotions--;
						System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
								+ "\n\t> You now have " + health + " HP."
								+ "\n\t> You have " + healthPotions + " health potions left.\n");
					} else {
						System.out.println("\t> You have no health potions left! Defeat enemies for a chance to pickup a health potion.");
					}
					
				} else if (input.equals("3")) {
					System.out.println("\tYou run away from the " + enemy + "!");
					continue GAME;
				} else {
					System.out.println("\tInvalid command! Try again");
				}
			}
			
			if(health < 0) {
				System.out.println("You limp out of the dungeon, weak from battle.");
				break;
			}
			System.out.println("-------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP left. #");
			if(randomNum.nextInt(100) < healthPotionDropChance) {
				healthPotions++;
				System.out.println(" # The " + enemy + " dropped a health potion! #");
				System.out.println(" # You now have " + healthPotions + " health potion(s). # ");
			}
			System.out.println("-------------------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit the dungeon");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid command!");
				input = in.nextLine();
			}
			
			if(input.equals("1")) {
				System.out.println("You continue on your adventure!");
			} else if(input.equals("2")) {
				System.out.println("You exit the dungeon, victorious!");
				break;
			}
		}
		
		System.out.println("#####################");
		System.out.println("#THANKS FOR PLAYING!#");
		System.out.println("#####################");
	}

}
