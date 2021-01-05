package AdventureGame;

public class Enemy {
	
	private String[] enemies = {"Lex Luthor", "Doomsday", "Brainiac", "Darkseid" };
	private int maxEnemyHealth = 100;
	private int maxEnemyAttackDamage = 25;
	
	public String[] getEnemies() {
		return enemies;
	}
	public void setEnemies(String[] enemies) {
		this.enemies = enemies;
	}
	public int getMaxEnemyHealth() {
		return maxEnemyHealth;
	}
	public void setMaxEnemyHealth(int maxEnemyHealth) {
		this.maxEnemyHealth = maxEnemyHealth;
	}
	public int getMaxEnemyAttackDamage() {
		return maxEnemyAttackDamage;
	}
	public void setMaxEnemyAttackDamage(int maxEnemyAttackDamage) {
		this.maxEnemyAttackDamage = maxEnemyAttackDamage;
	}
	
	

}
