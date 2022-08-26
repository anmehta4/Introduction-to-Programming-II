import java.util.Arrays;

public class PiggyBankTester {
  
  /**
   * Checks whether PiggyBank.getCoinName() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getCoinNameTestMethod() {
    // change some coin values and names
    // PiggyBank.COINS_NAMES[1] = "Two cents";
    // PiggyBank.COINS_NAMES[3] = "Fifty Cents";
    // PiggyBank.COINS_VALUES[1] = 2;
    // PiggyBank.COINS_VALUES[3] = 50;
    // consider all coin values as input arguments
    for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
      if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
        return false;
    // consider input argument which does not correspond to a coin value
    if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
      return false;
    if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
      return false;

    return true;
  }

  /**
   * Checks whether PiggyBank.getBalance() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getBalanceTestMethod() {

    // scenario 1 - empty piggy bank
    int[] coins = new int[10]; // array storing the coins held in a piggy bank
    int size = 0; // number of coins held in coins array
    if (PiggyBank.getBalance(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an empty piggy bank.");
      return false;
    }
    // scenario 2 - non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0, 0};
    size = 5;
    if (PiggyBank.getBalance(coins, size) != 42) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "two pennies, a nickel, a dime, and a quarter.");
      return false;
    }
    // scenario 3 - another non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0};
    size = 3;
    if (PiggyBank.getBalance(coins, size) != 16) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "a penny, a nickel, and a dime, only.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.getSpecificCoinCountMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getSpecificCoinCountTestMethod() {

    // scenario 1-coins exist in the bank
    int[] coins = new int[] {1, 5, 25, 25, 10, 5}; // array storing the coins held in a piggy bank
    int size = 6; // number of coins held in coins array
    if (PiggyBank.getSpecificCoinCount(25, coins, size) != 2) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCountMethod() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "a penny, two nickels, two dimes, and two quarters.");
      return false;
    }
    // scenario 2-coins do not exist in the bank
    coins = new int[] {1, 25, 10, 25};
    size = 4;
    if (PiggyBank.getSpecificCoinCount(5, coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.getSpecificCoinCountMethod() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "a penny, a dime and two quarters.");
      return false;
    }
    return true;
  }

  /**
   * Checks whether PiggyBank.addCoinMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean addCoinTestMethod() {

    // scenario 1- coin is added to a partly full PiggyBank
    int[] coins = new int[] {1, 5, 25, 10, 5, 1, 10, 0, 0, 0}; 
    int size = 7;
    if (PiggyBank.addCoin(25, coins, size) != size + 1) {
      System.out.println("Problem detected. Your PiggyBank.addCoinTestMethod() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "two pennies, two nickels, two dimes, and a quarter.");
      return false;
    }

    // scenario 2- coin is added to a full PiggyBank
    coins = new int[] {1, 5, 25, 10, 5, 1, 10}; // array storing the coins held in a piggy bank
    size = 7; // number of coins held in coins array
    if (PiggyBank.addCoin(25, coins, size) != size) {
      System.out.println("Problem detected. Your PiggyBank.addCoinTestMethod() did not "
          + "return the expected output when passed a full piggy bank.");
      return false;
    }

    // scenario 3- incorrect value coin is added to a partly full PiggyBank
    coins = new int[] {1, 5, 25, 10, 5, 1, 10, 0, 0, 0};
    size = 7;
    if (PiggyBank.addCoin(15, coins, size) != size) {
      System.out.println("Problem detected. Your PiggyBank.addCoinTestMethod() did not "
          + "return the expected output when an incorrect value coin passed an piggy bank "
          + "that holds " + "two pennies, two nickels, two dimes, and a quarter.");
      return false;
    }

    return true;
  }

  /**
   * Checks whether PiggyBank.removeCoinMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean removeCoinTestMethod() {
    // scenario 1- coin is removed from a partly full PiggyBank
    int[] coins = new int[] {1, 5, 25, 10, 5, 1, 10, 0, 0, 0};
    int size = 7;
    if (PiggyBank.removeCoin(coins, size) != size - 1) {
      System.out.println("Problem detected. Your PiggyBank.removeCoinTestMethod() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "two pennies, two nickels, two dimes, and a quarter.");
      return false;
    }

    // scenario 2- coin is removed from a full PiggyBank
    coins = new int[] {1, 5, 25, 10, 5, 1, 10}; // array storing the coins held in a piggy bank
    size = 7; // number of coins held in coins array
    if (PiggyBank.removeCoin(coins, size) != size - 1) {
      System.out.println("Problem detected. Your PiggyBank.removeCoinTestMethod() did not "
          + "return the expected output when passed an piggy bank that is full.");
      return false;
    }

    // scenario 3- incorrect value coin is removed from an empty PiggyBank
    coins = new int[] {0, 0, 0, 0};
    size = 0;
    if (PiggyBank.removeCoin(coins, size) != size) {
      System.out.println("Problem detected. Your PiggyBank.removeCoinTestMethod() did not "
          + "return the expected output when passed an piggy bank that is empty.");
      return false;
    }

    return true;

  }

  /**
   * Checks whether PiggyBank.removeCoinMethod() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean withdrawTestMethod() {

    // scenario 1 - Insufficient funds
    int[] coins = new int[] {5, 10, 25, 1, 1};
    int size = 5; // size of the array
    int amount = 50; // amount that should be withdrawn 
    int[] retArr = new int[] {5, 0, 0, 0, 0}; // array that should be returned
    if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size), retArr)) {
      System.out.println("Problem detected. Your PiggyBank.withdraw() did not "
          + "run as expected when a piggy bank with insufficient funds was " + "used.");
      return false;
    }

    // scenario 2 - Sufficient funds with exact change
    coins = new int[] {5, 10, 25, 1, 1};
    size = 5;
    amount = 15;
    retArr = new int[] {3, 0, 1, 1, 0};
    if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size), retArr)) {
      System.out.println("Problem detected. Your PiggyBank.withdraw() did not "
          + "run as expected when a piggy bank with exact change was " + "used.");
      return false;
    }

    // scenario 3 - Sufficient funds but not exact change
    coins = new int[] {5, 10, 25, 1, 1,5,10,25,5};
    size = 9;
    amount = 28;
    retArr = new int[] {7, 1, 0, 1, 0};
    if (!Arrays.equals(PiggyBank.withdraw(amount, coins, size), retArr)) {
      System.out.println("Problem detected. Your PiggyBank.withdraw() did not "
          + "run as expected when a piggy bank with sufficient funds but "
          + "not with exact change was used.");
      return false;
    }
    return true;

  }

  public static void main(String[] args) {

    // TODO Auto-generated method stub

    System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());
    getBalanceTestMethod();
    getSpecificCoinCountTestMethod();
    addCoinTestMethod();
    removeCoinTestMethod();
    withdrawTestMethod();
  }

}
