package AmountWithdrawal;

import Common.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    @Override
    public void withdraw(ATM atm, int amount) {
        int required=amount/500;
        int balance=amount%500;

        if(required< atm.getNoOfFiveHundredNotes()){
            atm.deductATMBalance(required);
        }else if(required> atm.getNoOfFiveHundredNotes()){
            balance=balance+(required-atm.getNoOfFiveHundredNotes())*500;
            atm.deductATMBalance(atm.getNoOfFiveHundredNotes());

        }

        if(balance>0){
            super.withdraw(atm, balance);
        }
    }
}
