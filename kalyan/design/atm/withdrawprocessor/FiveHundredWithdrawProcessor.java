package kalyan.design.atm.withdrawprocessor;

import kalyan.design.atm.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor processor) {
        super(processor);
    }
    public void withdraw(ATM atm, int amount) {
        int no = amount/500;
        int balance = amount%500;
        if(nextProcessor != null) {
            if(no <= atm.getNoOfFiveHundredNotes()) {
                atm.deductFiveHundredNotes(no);
            } else if(no > atm.getNoOfFiveHundredNotes()) {
                atm.deductFiveHundredNotes(atm.getNoOfTwoThousandNotes());
                balance = balance + (no-atm.getNoOfFiveHundredNotes()) * 500;
            }
            if(balance > 0)
                nextProcessor.withdraw(atm, balance);
        }
    }
}
