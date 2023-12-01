package kalyan.design.atm;

public class UserBankAccount {
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    int balance;
    public void updtateBalance(int amount) {
        this.balance = balance - amount;
    }
}
