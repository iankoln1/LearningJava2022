class Fight {

  private Wizard enemy;
  private Wizard you;

  public Fight(Wizard y) {
    this.enemy = new Wizard();
    this.you = y;
  }

  public Fight(Wizard y, Wizard e) {
    this.enemy = e;
    this.you = y;
  }

  public void start() {
    int sCount = 1;
    while (you.getHealth() > 0 && enemy.getHealth() > 0) {
      if (sCount % you.getSpeed() == 0) {
        enemy.setHealth(enemy.getHealth() - you.getAttackDamage());
        System.out.println("You used " + you.getAttackName() + ". The enemy now has " + enemy.getHealth() + " Health.");
      } 
      if (sCount % enemy.getSpeed() == 0) {
        you.setHealth(you.getHealth() - enemy.getAttackDamage());
        System.out.println("Enemy used " + enemy.getAttackName() + ". You now have " + you.getHealth() + " Health");
      }
      sCount++;
    }
    if (you.getHealth() <= 0 && enemy.getHealth() <= 0) {
      System.out.println("Both you and your enemy died!!");
    } else if (enemy.getHealth() <= 0) {
      System.out.println("You won the Fight!");
    } else {
      System.out.println("You lost the Fight!");
    }
      
    
  }


  
}
