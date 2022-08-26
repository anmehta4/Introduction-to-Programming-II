
public class Student {

  private int x; // x-coordinate of the students location
  private int y; // y-coordinate of the students location
  private int id; // unique number for each student

  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }

  public int getx() {
    return this.x;
  }

  public int gety() {
    return this.y;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "" + this.id + "(" + this.x + "," + this.y + ")";
  }

}
