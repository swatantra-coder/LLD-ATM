# LLD-ATM
## ATM Simulation Project

### Overview
This project simulates an ATM machine with basic functionalities such as cash withdrawal, balance checking, and card insertion. The project is implemented in Java and follows the State design pattern to manage the different states of the ATM.

### Features
- Insert Card
- Authenticate PIN
- Select Operation (Cash Withdrawal)
- Cash Withdrawal with denomination handling
- Eject Card

### Class Diagram
```uml
@startuml
class ATM {
    - int atmBalance
    - int twoThousandNotes
    - int fiveHundredNotes
    - int oneHundredNotes
    + getATMObject() : ATM
    + setAtmBalance(int, int, int, int) : void
    + getAtmBalance() : int
    + deductATMBalance(int) : void
    + printCurrentATMStatus() : void
    + setCurrentATMState(ATMState) : void
    + getCurrentATMState() : ATMState
}

class ATMState {
    + insertCard(ATM, Card) : void
    + authenticatePin(ATM, Card, int) : void
    + selectOperation(ATM, Card, TransactionType) : void
    + cashWithdrawal(ATM, Card, int) : void
    + exit(ATM) : void
    + returnCard() : void
}

class CashWithdrawalState extends ATMState {
    + cashWithdrawal(ATM, Card, int) : void
    + exit(ATM) : void
    + returnCard() : void
}

class IdleState extends ATMState {
    + insertCard(ATM, Card) : void
}

class Card {
    - int cardNumber
    - int cvv
    - String expiryDate
    - String cardHolderName
    - static int PIN_NUMBER
    - UserBankAccount userBankAccount
    + isPinValid(int) : boolean
    + getBankBalance() : int
    + withdraw(int) : void
    + deposit(int) : void
    + deductBankBalance(int) : int
    + setBankAccount(UserBankAccount) : void
}

class User {
    - Card card
    - UserBankAccount bankAccount
    + getCard() : Card
    + setCard(Card) : void
}

class UserBankAccount {
    - int balance
    + withdraw(int) : void
    + deposit(int) : void
}

class ATMRoom {
    - ATM atm
    - User user
    + main(String[]) : void
    - initialize() : void
    - createUser() : User
    - createCard() : Card
    - createBankAccount() : UserBankAccount
}

class CashWithdrawProcessor {
    + withdraw(ATM, int) : void
}

class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {
    + withdraw(ATM, int) : void
}

class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {
    + withdraw(ATM, int) : void
}

class OneHundredWithdrawProcessor extends CashWithdrawProcessor {
    + withdraw(ATM, int) : void
}

enum TransactionType {
    CASH_WITHDRAWAL
}

ATM "1" *-- "1" ATMState
ATMState <|-- CashWithdrawalState
ATMState <|-- IdleState
User "1" *-- "1" Card
User "1" *-- "1" UserBankAccount
ATMRoom "1" *-- "1" ATM
ATMRoom "1" *-- "1" User
CashWithdrawProcessor <|-- TwoThousandWithdrawProcessor
CashWithdrawProcessor <|-- FiveHundredWithdrawProcessor
CashWithdrawProcessor <|-- OneHundredWithdrawProcessor
@enduml
```

### How to Run
1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Run the `ATMRoom` class to start the simulation.

### Project Structure
- `src/ATMStates`: Contains the state classes for the ATM.
- `src/AmountWithdrawal`: Contains the classes for handling cash withdrawal with different denominations.
- `src/Common`: Contains common classes such as `ATM`, `Card`, `User`, and `UserBankAccount`.

### Dependencies
- Java 8 or higher
- IntelliJ IDEA 2022.2.2

### Usage
1. Insert the card.
2. Authenticate with the PIN.
3. Select the cash withdrawal operation.
4. Enter the amount to withdraw.
5. Collect the cash and card.

![image](https://github.com/user-attachments/assets/393c2140-9305-450b-b49d-9f0498019619)
