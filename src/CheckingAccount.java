/**
 * a checking account
 */
public class CheckingAccount extends BankAccount {

  public CheckingAccount(double initBalance) {
    super(initBalance);
    transactionCount = 0;
  }

  /**
   * @override withdraw in BankAccount class
   * @param amt amount to withdraw
   */
  @Override
  public void withdraw(double amt) {
    transactionCount++;
    super.withdraw(amt);
  }

  /**
   * @override deposit in BankAccount class
   * @param amt to deposit
   */
  @Override
  public void deposit(double amt) { // override
    transactionCount++;
    super.deposit(amt);
  }

  public void deductFees() { // new method
    if (transactionCount > FREE_TRANSACTIONS) {
      double fees = TRANSACTION_FEE *
                    (transactionCount - FREE_TRANSACTIONS);
      super.withdraw(fees);
    }
    transactionCount = 0;
  }

  private final int FREE_TRANSACTIONS = 3; // new member
  private final double TRANSACTION_FEE = 2.0; // new member
  private int transactionCount; // new instance member var

}
