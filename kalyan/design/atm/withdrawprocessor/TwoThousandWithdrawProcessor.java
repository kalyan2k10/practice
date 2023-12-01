package kalyan.design.atm.withdrawprocessor;

import kalyan.design.atm.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor processor) {
        super(processor);
    }
    public void withdraw(ATM atm, int amount) {
        int no = amount/2000;
        int balance = amount%2000;
        if(nextProcessor != null) {
            if(no <= atm.getNoOfTwoThousandNotes()) {
                atm.deductTwoThousandNotes(no);
            } else if(no > atm.getNoOfTwoThousandNotes()) {
                atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
                balance = balance + (no-atm.getNoOfTwoThousandNotes()) * 2000;
            }
            if(balance > 0)
                nextProcessor.withdraw(atm, balance);
        }
    }
}
