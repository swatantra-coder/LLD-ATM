package AmountWithdrawal;

import Common.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{

        public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
            super(cashWithdrawalProcessor);
        }

        @Override
        public void withdraw(ATM atm, int amount) {
            int required=amount/100;
            int balance=amount%100;

            if(required< atm.getNoOfOneHundredNotes()){
                atm.deductATMBalance(required);
            }else if(required> atm.getNoOfOneHundredNotes()){
                balance=balance+(required-atm.getNoOfOneHundredNotes())*100;
                atm.deductATMBalance(atm.getNoOfOneHundredNotes());

            }

            if(balance>0){
                super.withdraw(atm, balance);
            }
        }
}
