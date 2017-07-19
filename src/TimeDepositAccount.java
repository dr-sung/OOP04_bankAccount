/**
 * time deposit account - a special case of savings for a better interest rate
 */
public class TimeDepositAccount extends SavingsAccount {

  public TimeDepositAccount(double rate, int maturity) {
    super(rate); // call to immediate super class
                 //(--> SavingsAccount) constructor call
                 // Error if you don't call it explicitly
                 // since no default constructor is available in Super class.
    periodsToMaturity = maturity;
  }

  @Override
  public void addInterest() { // override
    --periodsToMaturity;
    super.addInterest();
  }

  @Override
  public void withdraw(double amt) { // override
    if (periodsToMaturity > 0)
      super.withdraw(EARLY_WITHDRAW_PENALTY);
    super.withdraw(amt);
  }

  private int periodsToMaturity; // new instance var
  private final double EARLY_WITHDRAW_PENALTY = 20.0; // new instance var

}
