/**
 * a generic bank account class as a parent class for checking, savings, etc
 */
public abstract class BankAccount {

  public BankAccount() {
    this(0);
  }

  public BankAccount(double balance) {
    this.balance = balance;
  }

  public void deposit(double amt) {
    balance = balance + amt;
  }

  public void withdraw(double amt) {
    balance = balance - amt;
  }

  public void transfer(BankAccount other, double amt) {
    withdraw(amt); other.deposit(amt);
  }

  public double getBalance() {
    return balance;
  }

  private double balance;

}
