package player;

public class Player {

  public static void main(String[] args) {
    Player p = new Player(80);
    p.takeDamage(25);
    p.printHealth();
    System.out.println("That should have printed Health: 55");
    p.healHealth(60);
    p.printHealth();
    System.out.println("That should have printed Health: 100");
    p.takeDamage(500);
    System.out.println("That should have printed 'You're dead!'");
    p.printHealth();
    System.out.println("That should have printed Health: 0");
  }

  // member variable, an int "health" value.
  int health;

  // constructor.
  public Player(int initialHealth) {
    health = initialHealth;
  }

  // It takes in one int damagePoints
  // Deduct the damagePoints from the player's health.
  // It has no return value.
  // A player's health should NEVER drop below 0.
  // If a player's health hits 0, print "You're dead!"
  public void takeDamage(int damagePoints){
    if (damagePoints >= health){
        health = 0;
    }else{
        health = health - damagePoints;
    }

    if (health == 0){
        System.out.println("You're dead!");
    }
  }

  // It takes in one int healPoints
  // Add the healPoints to the player's health.
  // It has no return value
  // A player's health should NEVER go above 100.
  public void healHealth (int healPoints){
    health += healPoints;
    if (health > 100){
        health = 100;
    }
  }

  public void printHealth() {
    System.out.println("Health: " + health);
  }

}

