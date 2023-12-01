package kalyan.design.atm;

public class Card {
    public int getCardNo() {
        return cardNo;
    }
    private UserBankAccount bankAccount;

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    int cardNo;
    int pin = 1234;
    public boolean isValidPIN(int pinNO){
        return this.pin == pinNO;
    }

    public UserBankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
