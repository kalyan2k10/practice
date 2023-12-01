package kalyan.design.atm.state;

import kalyan.design.atm.ATM;
import kalyan.design.atm.Card;

public class IdleState implements ATMState{
    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    ATMState atmState;

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card inserted with no " + card.getCardNo());
        atm.setCurrentATMState(new CardInserted());
    }

}
