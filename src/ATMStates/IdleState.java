package ATMStates;

import Common.ATM;
import Common.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atmObject, Card card) {
        System.out.println("Card Inserted");
        atmObject.setCurrentATMState(new HashCardState());
    }
}
