package kalyan.design.atm.state;

import kalyan.design.atm.ATM;
import kalyan.design.atm.Card;
import kalyan.design.atm.TransactionType;

public interface ATMState {
    default void insertCard(ATM atm, Card card) { }
    default void authenticatePin(ATM atm, Card card, int pin) {}
    default void processTransaction(ATM atm, Card card, TransactionType transactionType) {}
    default void displayBalance(ATM atm, Card card){}
    default void cashWithdrawal(ATM atm, Card card, int amt) {}
    default void exit() {}
}
