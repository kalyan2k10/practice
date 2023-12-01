package kalyan.design.atm.state;

import kalyan.design.atm.ATM;
import kalyan.design.atm.Card;

public class CardInserted implements ATMState {
    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        if(card.isValidPIN(pin))
            atm.setCurrentATMState(new SelectTransactionType());
        else
            atm.setCurrentATMState(new IdleState());
    }
}
