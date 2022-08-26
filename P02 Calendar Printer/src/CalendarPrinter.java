import java.util.Scanner;
import java.util.ArrayList;

public class CalendarPrinter {

  /**
   * Calculates the number of centuries (rounded down) between year 0 and the specified year. For
   * example, the year 2034 has the century index of 20 (as do the other years 2000-2099).
   * 
   * @param year to compute the century offset for
   * @return number of centuries between year 0 and the specified year
   */
  public static int fullCenturiesContained(Year year) {
    int centuryContained = year.intValue() / 100;
    return centuryContained;
  }

  /**
   * Calculates the number of years between the specified year and the first year of its century.
   * For example, the year 2034 has the offset within its century of 34 (as do 1234 and 9999934).
   * 
   * @param year to compute the offset within century for
   * @return number of years between the specified year and the first year of century
   */
  public static int yearOffsetWithinCentury(Year year) {
    int offset = year.intValue() % 100;// gives the remaining years after the closest multiple of
                                       // 100
    return offset;
  }

  /**
   * This method computes whether the specified year is a leap year or not.
   * 
   * @param year is the year is being checked for leap-year-ness
   * @return true when the specified year is a leap year, and false otherwise
   */
  public static boolean isLeapYear(Year year) {

    if ((year.intValue() % 4) != 0) // checks the different conditions for a leap year
      return false;
    else if ((year.intValue() % 100) != 0)
      return true;
    else if ((year.intValue() % 400) != 0)
      return false;
    else
      return true;

  }

  /**
   * Calculates the number of days in the specified month, while taking into consideration whether
   * or not the specified month is in a leap year. Note: that this is calculated based on the
   * month's monthOfYear and year, and is NOT retrieved from the month's getDayCount() method. This
   * is because this method is used to generate the day objects that are stored within each month.
   * 
   * @param month to determine the number of days within (within its year)
   * @return the number of days in the specified month (between 28-31)
   */

  public static int numberOfDaysInMonth(Month month) {
    if (month.getMonthOfYear().toString().equalsIgnoreCase("February")) {
      if (isLeapYear(month.getYear())) { // checks if month is February and in a leap year or not
        return 29;
      } else {
        return 28;
      }
    } else if (month.getMonthOfYear().toString()
        .matches("January|March|May|July|August|October|December")) {
      return 31; // returns 31 for the above months or returns 30
    } else {
      return 30;
    }
  }

  /**
   * Calculates which day of the week the first day of the specified month falls on. Note: that this
   * is calculated based on the month's monthOfYear and year, and is NOT retrieved from the month's
   * getDayByDate(1) day. This is because this method is used to generate the day objects that are
   * stored within each month.
   * 
   * @param month within which we are calculate the day of week for the first day
   * @return DayOfWeek corresponding to the first day within the specified month
   */
  public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
    int yearOfTheMonth = month.getYear().intValue();
    String monthName = month.getMonthOfYear().name();
    int monthNumber = 0;// m
    switch (monthName) { // determines the value of m in the formula
      case "January":
        monthNumber = 13;
        break;
      case "February":
        monthNumber = 14;
        break;
      case "March":
        monthNumber = 3;
        break;
      case "April":
        monthNumber = 4;
        break;
      case "May":
        monthNumber = 5;
        break;
      case "June":
        monthNumber = 6;
        break;
      case "July":
        monthNumber = 7;
        break;
      case "August":
        monthNumber = 8;
        break;
      case "September":
        monthNumber = 9;
        break;
      case "October":
        monthNumber = 10;
        break;
      case "November":
        monthNumber = 11;
        break;
      case "December":
        monthNumber = 12;
        break;
    }

    if (monthName.matches("January|February"))
      yearOfTheMonth -= 1;

    int yearOfCentury = (yearOfTheMonth) % 100; // K - determining the value of K
    int zeroBasedCentury = (yearOfTheMonth) / 100; // J - determining the value of J

    int day = (1 + yearOfCentury + (yearOfCentury / 4) + (zeroBasedCentury / 4)
        + 5 * (zeroBasedCentury) + (13 * (monthNumber + 1)) / 5) % 7;

    switch (day) { // returning the day based on the number obtained in the above formula
      case 0:
        return DayOfWeek.Saturday;
      case 1:
        return DayOfWeek.Sunday;
      case 2:
        return DayOfWeek.Monday;
      case 3:
        return DayOfWeek.Tuesday;
      case 4:
        return DayOfWeek.Wednesday;
      case 5:
        return DayOfWeek.Thursday;
      case 6:
        return DayOfWeek.Friday;
      default:
        return null;

    }
  }

  /**
   * Calculates the day of the week that follows the specified day of week. For example, Thursday
   * comes after Wednesday, and Monday comes after Sunday.
   * 
   * @param dayBefore is the day of week that comes before the day of week returned
   * @return day of week that comes after dayBefore
   */
  public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {

    switch (dayBefore.toString()) { // returning the day after based on the day before
      case "Monday":
        return DayOfWeek.Tuesday;
      case "Tuesday":
        return DayOfWeek.Wednesday;
      case "Wednesday":
        return DayOfWeek.Thursday;
      case "Thursday":
        return DayOfWeek.Friday;
      case "Friday":
        return DayOfWeek.Saturday;
      case "Saturday":
        return DayOfWeek.Sunday;
      case "Sunday":
        return DayOfWeek.Monday;
      default:
        return null;
    }
  }

  /**
   * Calculates the month of the year that follows the specified month. For example, July comes
   * after June, and January comes after December.
   * 
   * @param monthBefore is the month that comes before the month that is returned
   * @return month of year that comes after monthBefore
   */
  public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {

    switch (monthBefore.toString()) { // returning the month after based on the month before
      case "January":
        return MonthOfYear.February;
      case "February":
        return MonthOfYear.March;
      case "March":
        return MonthOfYear.April;
      case "April":
        return MonthOfYear.May;
      case "May":
        return MonthOfYear.June;
      case "June":
        return MonthOfYear.July;
      case "July":
        return MonthOfYear.August;
      case "August":
        return MonthOfYear.September;
      case "September":
        return MonthOfYear.October;
      case "October":
        return MonthOfYear.November;
      case "November":
        return MonthOfYear.December;
      case "December":
        return MonthOfYear.January;
      default:
        return null;
    }
  }

  /**
   * Prints the contents of the specified month object in calendar form. This printout should begin
   * with the Month an year of the month. The next line should contain the three letter
   * abbreviations for the seven days of the week. And then the dates of each day of that month
   * should follow: one week per line, with periods in positions of days that are a part of the
   * month before or after. For example, January 2020 should be printed as follows:
   *
   * January 2020 MON TUE WED THU FRI SAT SUN . . 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
   * 21 22 23 24 25 26 27 28 29 30 31 . .
   *
   * @param month which is to be printed by this method
   */
  public static void printMonth(Month month) {

    System.out.println(month.toString()); // printing the month and year
    System.out.println(
        "MON" + " " + "TUE" + " " + "WED" + " " + "THU" + " " + "FRI" + " " + "SAT" + " " + "SUN"); 
    DayOfWeek x = calcFirstDayOfWeekInMonth(month);

    int start = 0; // finding where the first day starts from
    if ((x.toString()).equals("Monday"))
      start = 0;
    else if ((x.toString()).equals("Tuesday"))
      start = 1;
    else if ((x.toString()).equals("Wednesday"))
      start = 2;
    else if ((x.toString()).equals("Thursday"))
      start = 3;
    else if ((x.toString()).equals("Friday"))
      start = 4;
    else if ((x.toString()).equals("Saturday"))
      start = 5;
    else if ((x.toString()).equals("Sunday"))
      start = 6;

    int date = 1;
    int numDays = numberOfDaysInMonth(month);

    for (int m = 0; m < start; m++) // printing the dots in the first row
      System.out.print(" " + "." + "  ");

    for (int n = start; n < 7; n++) { // printing the dates in the remaining spots of the first row
      System.out.print(" " + date + "  ");
      date++;
    }
    System.out.println();

    int numRows = (numDays - date + 1) / 7; // the number of rows completely occupied in the month
    for (int m = 1; m <= numRows; m++) { // printing all the dates
      for (int n = 0; n < 7; n++) {
        if (date < 10)
          System.out.print(" " + date + "  ");
        else
          System.out.print(" " + date + " ");
        date++;
      }
      System.out.println();
    }

    for (int k = 0; k < 7; k++) {

      if (date <= numDays) { // printing the remaining dates in the last row
        if (date < 10)
          System.out.print(" " + date + " ");
        else
          System.out.print(" " + date + " ");

        date++;
      } else // printing the dots in the remaining spots in the last row
        System.out.print(" " + "." + "  ");
    }
    System.out.println();
    System.out.println();

  }

  /**
   * Creates a new month object and fully initializes with its corresponding days.
   * 
   * @param monthOfYear which month of the year this new month represents
   * @param year        in which this month is a part
   * @return reference to the newly created month object
   */
  public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {

    Month MonthOfYear = new Month(monthOfYear, year);
    int dayCount = numberOfDaysInMonth(MonthOfYear);
    DayOfWeek dayToAdd = calcFirstDayOfWeekInMonth(MonthOfYear);

    for (int i = 1; i <= dayCount; ++i) {
      Day createDay = new Day(dayToAdd, i, MonthOfYear);
      MonthOfYear.addDay(createDay);
      dayToAdd = dayOfWeekAfter(dayToAdd);
    }

    return MonthOfYear;

  }

  /**
   * Creates an array list of months that are initialized with their full complement of days. Prints
   * out each of these months in calendar form, and then returns the resulting ArrayList.
   * 
   * @param month of the year for the first month that is created and printed
   * @param year  that the first month created and printed is a part of
   * @param count is the total number of sequential months created and printed
   */
  public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count) {
    ArrayList<Month> retArr = new ArrayList<Month>();
    Month start = createNewMonth(month, year);

    for (int i = 0; i < count; i++) {

      if (start.getMonthOfYear().toString().equalsIgnoreCase("December")) {
        printMonth(start); // prints the December month
        retArr.add(start); // adds the December month to the array list
        year = new Year(year.intValue() + 1); // incrementing the year
        // initializing start to January of the next year
        start = createNewMonth(MonthOfYear.January, year);


      } else {
        printMonth(start); // prints the month
        retArr.add(start); // adds the month to the array list
        // initializing start to the incremented the month
        start = createNewMonth(monthOfYearAfter(start.getMonthOfYear()), year);
      }

    }
    return retArr;
  }



  /**
   * Driver for the CalendarPrinter Application. This program asks the user to enter an initial
   * month, an initial year, and the total number of months to create and display in calendar form.
   * 
   * @param args is not used by this program
   */
  public static void main(String[] args) {
    // print welcome message
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to the Calendar Printer.");
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    // read input from the user
    System.out.print("Enter the month to begin calendar: ");
    String monthString = in.nextLine().trim();
    System.out.print("Enter the year to begin calendar: ");
    String yearString = in.nextLine().trim();
    System.out.print("Enter the number of months to include in this calendar: ");
    String countString = in.nextLine().trim();
    // convert user input into usable form
    monthString = monthString.substring(0, 3).toUpperCase();
    MonthOfYear month = null;
    for (int i = 0; i < MonthOfYear.values().length; i++)

      if (monthString.equals(MonthOfYear.values()[i].name().substring(0, 3).toUpperCase()))
        month = MonthOfYear.values()[i];
    Year year = new Year(Integer.parseInt(yearString.trim()));
    int count = Integer.parseInt(countString.trim());
    // create months and display them in calendar form
    System.out.println();
    createAndPrintMonths(month, year, count);
    // display thank you message
    System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
    System.out.println("Thanks, and have a nice day.");
    in.close();
  }
}


