package kalyan.design.atm.state;


import kalyan.design.atm.ATM;
import kalyan.design.atm.Card;

public class BalanceCheckState implements ATMState {
    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your Balance is: " + card.getBankAccount().getBalance());
        atm.setCurrentATMState(new IdleState());
    }
}
