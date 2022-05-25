class House {

  private String name;
  private Attack attack;
  private int health;
  private int speed;

  public House(String n, Attack a, int h, int s) {
    this.name = n;
    this.attack = a;
    this.health = h;
    this.speed = s;
  }

  public String getName() {
    return name;
  }
  
  public int getHealth() {
    return health;
  }
  public int getSpeed() {
    return speed;
  }

  public int getAttackDamage() {
    return attack.getDamage();
  }
  public String getAttackName(){
    return attack.getName();
  }
}
