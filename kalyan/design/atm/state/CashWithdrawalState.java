package kalyan.design.atm.state;



import kalyan.design.atm.withdrawprocessor.CashWithdrawProcessor;
import kalyan.design.atm.ATM;
import kalyan.design.atm.Card;
import kalyan.design.atm.withdrawprocessor.FiveHundredWithdrawProcessor;
import kalyan.design.atm.withdrawprocessor.OneHundredWithdrawProcessor;
import kalyan.design.atm.withdrawprocessor.TwoThousandWithdrawProcessor;

public class CashWithdrawalState implements ATMState {
    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {
        if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            atmObject.setCurrentATMState(new IdleState());
        } else if (card.getBankAccount().getBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            atmObject.setCurrentATMState(new IdleState());
        } else {
            card.getBankAccount().updtateBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);
            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            atmObject.setCurrentATMState(new IdleState());
        }
    }
}
