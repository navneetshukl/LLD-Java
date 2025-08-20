/* This part is implemented by me

class HasCardState implements AtmState {

    public void InsertCard(Atm atm) {
        System.out.println("Card Is ALreday inserted");
        

    }

    public void EnterPin(Atm atm) {
        System.out.println("Pin is inserted");
        atm.changeState(new MoneyState());

    }

    public void TakeMoney(Atm atm) {
        System.out.println("First Enter the Pin");
    }
}

*/

// this code is suggested by grok

public class HasCardState implements ATMState {
    private static final String CORRECT_PIN = "1234"; // Example PIN

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Error: Card is already inserted.");
    }

    @Override
    public void enterPin(ATM atm, String pin) {
        if (CORRECT_PIN.equals(pin)) {
            System.out.println("PIN verified successfully.");
            atm.transitionTo(new AuthenticatedState());
        } else {
            System.out.println("Error: Invalid PIN. Ejecting card.");
            atm.transitionTo(new IdleState());
        }
    }

    @Override
    public void withdrawMoney(ATM atm, double amount) {
        System.out.println("Error: Please enter a valid PIN first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected successfully.");
        atm.transitionTo(new IdleState());
    }
}
