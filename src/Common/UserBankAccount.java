package Common;

public class UserBankAccount {

    int balance;

    public void withdraw(int amount){
        balance -= amount;
    }

    public void deposit(int amount){
        balance += amount;
    }
}
