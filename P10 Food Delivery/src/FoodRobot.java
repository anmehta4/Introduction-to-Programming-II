
public class FoodRobot {

  private int x; // x-coordinate of the students location
  private int y; // y-coordinate of the students location
  private String name; // unique number for each student

  public FoodRobot(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }

  public int getx() {
    return this.x;
  }

  public int gety() {
    return this.y;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return this.name + "(" + this.x + "," + this.y + ")";
  }

}
