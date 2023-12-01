package kalyan.design.atm.withdrawprocessor;

import kalyan.design.atm.ATM;

public class CashWithdrawProcessor {
    CashWithdrawProcessor nextProcessor;

    public CashWithdrawProcessor(CashWithdrawProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void withdraw(ATM atm, int amount) {
        if(nextProcessor != null)
            nextProcessor.withdraw(atm, amount);
    }

}
