/**
 * demonstrate overriding vs. overloading
 */
public class TestBankAccount {

  public static void main(String[] args) {

    SavingsAccount momsSavings = new SavingsAccount(0.5);

    TimeDepositAccount collegeFund = new TimeDepositAccount(1, 3);

    CheckingAccount harrysChecking = new CheckingAccount(0);

    momsSavings.deposit(10000);
    collegeFund.deposit(10000);

    momsSavings.transfer(harrysChecking, 2000);
    collegeFund.transfer(harrysChecking, 980);

    harrysChecking.withdraw(500);
    harrysChecking.withdraw(80);
    harrysChecking.withdraw(400);

    endOfMonth(momsSavings);
    endOfMonth(collegeFund);
    endOfMonth(harrysChecking);

    printBalance("mom's savings", momsSavings);
    // $10000 - $2000 + 0.5% interest = $8040
    printBalance("the college fund", collegeFund);
    // $10000 - $980 - $20 penalty + 1% interest
    // = $9090
    printBalance("Harry's checking", harrysChecking);
    // $2000 + $980 - $500 - $80 - $400 - $4 fees
    // = $1996
  }

  // Demo of method overloading and overriding (polymorphism)
  public static void endOfMonth(SavingsAccount savings) {
    savings.addInterest(); // polymorphism occurs here!
  }

  public static void endOfMonth(CheckingAccount checking) {
    checking.deductFees();
  }

  public static void printBalance(String name, BankAccount account) {
    System.out.println("The balance of " + name + " account is $"
             + account.getBalance());
  }
}
