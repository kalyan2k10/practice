package kalyan.design.atm.withdrawprocessor;

import kalyan.design.atm.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {
    public OneHundredWithdrawProcessor(CashWithdrawProcessor processor) {
        super(processor);
    }

    public void withdraw(ATM atm, int amount) {
        int no = amount / 100;
        int balance = amount % 100;

        if (no <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(no);
        } else if (no > atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (no - atm.getNoOfOneHundredNotes()) * 100;
        }
        if (balance > 0)
            System.out.println("This should not happen");

    }
}
