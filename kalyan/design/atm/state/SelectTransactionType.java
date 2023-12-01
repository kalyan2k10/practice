package kalyan.design.atm.state;

import kalyan.design.atm.ATM;
import kalyan.design.atm.Card;
import kalyan.design.atm.TransactionType;

public class SelectTransactionType implements ATMState {
    @Override
    public void processTransaction(ATM atm, Card card, TransactionType transactionType) {
        if(transactionType == TransactionType.BALANCE_CHECK){
            atm.setCurrentATMState(new BalanceCheckState());
        } else {
            atm.setCurrentATMState(new CashWithdrawalState());
        }
    }
}
