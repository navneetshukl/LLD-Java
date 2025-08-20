/*  This part is implemented by me

interface AtmState {

    void InsertCard(Atm atm);

    void EnterPin(Atm atm);

    void TakeMoney(Atm atm);

}
*/

// This is suggested by grok

public interface ATMState {
    void insertCard(ATM atm);
    void enterPin(ATM atm, String pin);
    void withdrawMoney(ATM atm, double amount);
    void ejectCard(ATM atm);
}