public class CalendarTester {

  /**
   * Checks whether CalendarPrinter.fullCenturiesContained() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testFullCenturiesContained() {

    // scenario 1- year is not greater than 100
    if (CalendarPrinter.fullCenturiesContained(new Year(5)) != 0)
      return false;

    // scenario 2- year is greater that 100
    if (CalendarPrinter.fullCenturiesContained(new Year(1020)) != 10)
      return false;

    // scenario- year is greater than 100
    if (CalendarPrinter.fullCenturiesContained(new Year(77777)) != 777)
      return false;
    return true;
  }

  /**
   * Checks whether CalendarPrinter.yearOffsetWithinCentury() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testYearOffsetWithinCentury() {

    // scenario 1,2 & 3 are greater than a century but differ in magnitude
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(1907)) != 7)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(2019)) != 19)
      return false;
    if (CalendarPrinter.yearOffsetWithinCentury(new Year(44444)) != 44)
      return false;
    return true;
  }

  /**
   * Checks whether CalendarPrinter.isLeapYear() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testIsLeapYear() {


    // scenario 1- year is not divisible by 4
    if (CalendarPrinter.isLeapYear(new Year(1906)) != false)
      return false;

    // scenario 2- year is divisible by 4
    if (CalendarPrinter.isLeapYear(new Year(2020)) != true)
      return false;

    // scenario 3- year is divisible by 4
    if (CalendarPrinter.isLeapYear(new Year(44444)) != true)
      return false;

    return true;
  }

  /**
   * Checks whether CalendarPrinter.testNumberOfDaysInMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testNumberOfDaysInMonth() {

    // scenario 1- a month with 31 days
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.January, new Year(2020))) != 31)
      return false;

    // scenario 2- February in a leap year
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2020))) != 29)
      return false;

    // scenario 3- February in a non-leap year
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2019))) != 28)
      return false;

    // scenario 4- a month with 30 days
    if (CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.April, new Year(1996))) != 30)
      return false;
    return true;
  }

  /**
   * Checks whether CalendarPrinter.calcFirstDayOfWeekInMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testCalcFirstDayOfWeekInMonth() {

    // scenarios 1,2,3 - trying different months and years and testing it based on the calendar

    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.January, new Year(2020))) != DayOfWeek.Wednesday)
      return false;
    if (CalendarPrinter
        .calcFirstDayOfWeekInMonth(new Month(MonthOfYear.June, new Year(2001))) != DayOfWeek.Friday)
      return false;
    if (CalendarPrinter.calcFirstDayOfWeekInMonth(
        new Month(MonthOfYear.December, new Year(1996))) != DayOfWeek.Sunday)
      return false;
    return true;
  }

  /**
   * Checks whether CalendarPrinter.dayOfWeekAfter() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testDayOfWeekAfter() {

    // scenarios 1,2,3 - trying different days of the week to ensure
    // it gives the next day (especially Sunday)

    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Friday) != DayOfWeek.Saturday)
      return false;
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday) != DayOfWeek.Monday)
      return false;
    if (CalendarPrinter.dayOfWeekAfter(DayOfWeek.Tuesday) != DayOfWeek.Wednesday)
      return false;
    return true;
  }


  /**
   * Checks whether CalendarPrinter.monthOfYearAfter() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testMonthOfYearAfter() {

    // scenarios 1,2,3 - trying different months of the year to ensure
    // it gives the next month (especially December)

    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.December) != MonthOfYear.January)
      return false;
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.June) != MonthOfYear.July)
      return false;
    if (CalendarPrinter.monthOfYearAfter(MonthOfYear.August) != MonthOfYear.September)
      return false;
    return true;

  }

  /**
   * Checks whether CalendarPrinter.createNewMonth() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */

  public static boolean testCreateNewMonth() {

    if ((CalendarPrinter.createNewMonth(MonthOfYear.January, new Year(2020)).getDayByDate(14)
        .getDayOfWeek()) != DayOfWeek.Tuesday)
      return false;
    if ((CalendarPrinter.createNewMonth(MonthOfYear.December, new Year(2020)).getDayByDate(1)
        .getDayOfWeek()) != DayOfWeek.Tuesday)
      return false;
    if ((CalendarPrinter.createNewMonth(MonthOfYear.February, new Year(2020)).getDayByDate(29)
        .getDayOfWeek()) != DayOfWeek.Saturday)
      return false;
    return true;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testFullCenturiesContained());
    System.out.println(testYearOffsetWithinCentury());
    System.out.println(testIsLeapYear());
    System.out.println(testNumberOfDaysInMonth());
    System.out.println(testCalcFirstDayOfWeekInMonth());
    System.out.println(testDayOfWeekAfter());
    System.out.println(testMonthOfYearAfter());
    System.out.println(testCreateNewMonth());
  }

}
