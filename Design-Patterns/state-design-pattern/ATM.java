/* This part is implemented by me

class Atm {

    AtmState atmState;

    Atm() {
        atmState=new IdleState();
    }

    void changeState(AtmState state) {
        this.atmState = state;
    }

    void InsertCard(){
        atmState.InsertCard(this);
    }

    void EnterPin(){
        atmState.EnterPin(this);
    }

    void TakeMoney(){
        atmState.TakeMoney(this);
    }

}
*/

// this part is suggested by grok

public class ATM {
    private ATMState currentState;
    private double balance; // Added to track account balance

    public ATM() {
        this.currentState = new IdleState();
        this.balance = 1000.0; // Example initial balance
    }

    private void setState(ATMState state) {
        if (state != null) {
            this.currentState = state;
        } else {
            throw new IllegalArgumentException("State cannot be null");
        }
    }

    public void insertCard() {
        currentState.insertCard(this);
    }

    public void enterPin(String pin) {
        currentState.enterPin(this, pin);
    }

    public void withdrawMoney(double amount) {
        currentState.withdrawMoney(this, amount);
    }

    public void ejectCard() {
        currentState.ejectCard(this);
    }

    // Getters and setters for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // State transition method
    public void transitionTo(ATMState state) {
        setState(state);
    }
}