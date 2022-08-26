
public class Delivery implements Comparable<Delivery> {

  private int studentId;
  private String robotName;
  private int distance;

  public Delivery(Student student, FoodRobot robot) {
    studentId = student.getId();
    robotName = robot.getName();

    this.distance =
        Math.abs(student.getx() - robot.getx()) + Math.abs(student.gety() - robot.gety());
  }

  @Override
  public int compareTo(Delivery o) {

    if (o.distance < this.distance)
      return 1;
    else if (o.distance > this.distance)
      return -1;
    else {
      if (o.studentId == this.studentId) {
        if (o.robotName.compareTo(this.robotName) > 0)
          return -1;
        else
          return 1;
      } else {
        if (o.studentId > this.studentId)
          return -1;
        else
          return 1;
      }
    }
  }

  public boolean equals(Object obj) {

    if (obj instanceof Delivery) {

      if (((Delivery) obj).studentId == this.studentId)
        return true;
      else if (((Delivery) obj).robotName.equals(this.robotName))
        return true;
      else
        return false;
    } else if (obj instanceof Student) {

      if (((Student) obj).getId() == this.studentId)
        return true;
      else
        return false;
    } else if (obj instanceof FoodRobot) {
      if (((FoodRobot) obj).getName().equals(this.robotName))
        return true;
      else
        return false;
    } else
      return false;

  }

  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + " is " + distance;
  }
}


