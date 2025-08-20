/* This part is implemented by me
public class Bank{
    public static void main(String[] args) {
        Atm atm=new Atm();

        atm.EnterPin();
        atm.InsertCard();
        atm.TakeMoney();
    }
}

 */

// this part is suggested by grok
public class Bank {

    public static void main(String[] args) {
        ATM atm = new ATM();

        // Test valid flow
        System.out.println("Test Case 1: Valid transaction");
        atm.insertCard();
        atm.enterPin("1234");
        atm.withdrawMoney(500.0);

        // Test invalid PIN
        System.out.println("\nTest Case 2: Invalid PIN");
        atm.insertCard();
        atm.enterPin("9999");

        // Test invalid sequence
        System.out.println("\nTest Case 3: Invalid sequence");
        atm.enterPin("1234"); // No card inserted
        atm.withdrawMoney(100.0); // No card inserted

        // Test card ejection
        System.out.println("\nTest Case 4: Eject card");
        atm.insertCard();
        atm.ejectCard();
    }
}
