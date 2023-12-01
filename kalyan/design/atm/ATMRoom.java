package kalyan.design.atm;



public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String args[]) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, 1234);
        atmRoom.atm.getCurrentATMState().processTransaction(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, 1234);
        atmRoom.atm.getCurrentATMState().processTransaction(atmRoom.atm, atmRoom.user.card, TransactionType.BALANCE_CHECK);
        atmRoom.atm.getCurrentATMState().displayBalance(atmRoom.atm, atmRoom.user.card);
    }

    private void initialize() {

        //create ATM
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500, 1,2,5);

        //create User
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 3000;
        Card card = new Card();
        card.setBankAccount(bankAccount);

        User user = new User();
        user.setCard(card);
        this.user = user;
    }
}
