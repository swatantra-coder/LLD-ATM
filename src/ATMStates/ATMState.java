package ATMStates;

import Common.ATM;
import Common.Card;
import Common.TransactionType;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card) {
        System.out.println("Card has been inserted");
    }

    public void authenticatePin(ATM atm, Card card,int pin) {
        System.out.println("Pin has been authenticated");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        System.out.println("Operation has been selected");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        System.out.println("Cash has been withdrawn");
    }

    public void displayBalance(ATM atm, Card card) {
        System.out.println("Balance has been displayed");
    }

    public void ejectCard() {
        System.out.println("Card has been ejected");
    }

    public void exit(ATM atm) {
        System.out.println("Exit");
    }

    public abstract void returnCard();
}
