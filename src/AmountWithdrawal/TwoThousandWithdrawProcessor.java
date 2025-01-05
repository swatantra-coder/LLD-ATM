package AmountWithdrawal;

import Common.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{

        public TwoThousandWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {
            super(cashWithdrawalProcessor);
        }

        @Override
        public void withdraw(ATM atm, int amount) {
            int required=amount/2000;
            int balance=amount%2000;

            if(required< atm.getNoOfTwoThousandNotes()){
                atm.deductATMBalance(required);
            }else if(required> atm.getNoOfTwoThousandNotes()){
                balance=balance+(required-atm.getNoOfTwoThousandNotes())*2000;
                atm.deductATMBalance(atm.getNoOfTwoThousandNotes());

            }

            if(balance>0){
                super.withdraw(atm, balance);
            }
        }
}
