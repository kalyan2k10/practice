package LowLevelDesign.DesignATM;

public class UserBankAccountt {

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    int balance;

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }
}
