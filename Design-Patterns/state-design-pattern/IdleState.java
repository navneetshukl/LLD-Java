/* This part is implemented by me

class IdleState implements AtmState {

    public void InsertCard(Atm atm) {
        System.out.println("Card Is inserted");
        atm.changeState(new HasCardState());

    }

    public void EnterPin(Atm atm) {
        System.out.println("First Insert the card");

    }

    public void TakeMoney(Atm atm) {
        System.out.println("First Insert the card");
    }
}
*/

// This part is suggested by grok

public class IdleState implements ATMState {
    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card inserted successfully.");
        atm.transitionTo(new HasCardState());
    }

    @Override
    public void enterPin(ATM atm, String pin) {
        System.out.println("Error: Please insert a card first.");
    }

    @Override
    public void withdrawMoney(ATM atm, double amount) {
        System.out.println("Error: Please insert a card first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Error: No card to eject.");
    }
}
