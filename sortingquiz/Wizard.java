class Wizard {

  private int health;
  private House house;
  private House Gryffindor = new House("Gryffindor", new Attack(15, "AllahKazam"), 100, 5);
  private House Ravenclaw = new House("Ravenclaw", new Attack(20, "WallahiKadabra"), 80, 10);
  private House Hufflepuff = new House("Hufflepuff", new Attack(10, "Mushallah Leviosa"), 50, 1);
  private House Slytherin = new House("Slytherin", new Attack(30, "Whudya-Whudya"), 75, 10);
  private final House[] houses = {Gryffindor, Ravenclaw, Hufflepuff, Slytherin};

  public Wizard() {
    this.house = houses[(int)(Math.random() * 4)];
    this.health = house.getHealth();
  }
  
  public Wizard(String n) {
    for (House h : houses) {
      if 
    }
    this.house = h;
    this.health = house.getHealth();
  }

  public int getHealth() {
    return health;
  }

  public int getSpeed() {
    return house.getSpeed();
  }

  public int getAttackDamage() {
    return house.getAttackDamage();
  }

  public String getAttackName() {
    return house.getAttackName();
  }

  public void setHealth(int h) {
    health = h;
  }

  //public 
  
}
