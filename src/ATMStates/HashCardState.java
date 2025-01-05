package ATMStates;

import Common.ATM;
import Common.Card;

public class HashCardState extends ATMState{

    public HashCardState(){
        System.out.println("Card Hashed");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPin = card.isPinValid(pin);
        if(isCorrectPin) {
            atm.setCurrentATMState(new SelectOperationState());
        } else {
            System.out.println("Incorrect Pin");
        }
    }
}
