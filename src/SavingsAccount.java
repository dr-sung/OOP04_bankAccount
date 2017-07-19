/**
 * saving account
 */
public class SavingsAccount extends BankAccount {
  
  public SavingsAccount(double rate) {
    // Since no super constructor is called,
    //default super constructor is called.
    interestRate = rate;
  }

  public void addInterest() { // new method
    double interest = getBalance() * interestRate / 100.0;
    deposit(interest);
  }

  private final double interestRate; // new member

}
