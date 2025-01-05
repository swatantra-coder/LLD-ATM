package Common;

public class Card {
    int cardNumber;
    int cvv;
    String expiryDate;
    String cardHolderName;

    static int PIN_NUMBER = 1234;

    UserBankAccount userBankAccount;

    public boolean isPinValid(int pin){
        return pin == PIN_NUMBER;
    }

    public int getBankBalance(){
        return userBankAccount.balance;
    }

    void withdraw(int amount){
        userBankAccount.withdraw(amount);
    }

    void deposit(int amount){
        userBankAccount.deposit(amount);
    }
    public int deductBankBalance(int amount){
        userBankAccount.balance -= amount;
        return userBankAccount.balance;
    }

    public void setBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }

}
