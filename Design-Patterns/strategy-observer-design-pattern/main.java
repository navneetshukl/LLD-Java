
public class main {

    public static void main(String[] args) {
        bank b = new bank("123456@bank", 100);
        upi u = new upi("123456@upi", 200);
        credit c = new credit("123456@credit", 300);

        email e = new email("navneet@shukla");
        msg m = new msg("123456");
        paymoney pay = new paymoney(b);
        pay.addObserver(e);
        pay.doPayment();
        pay.changeMethod(u);
        pay.addObserver(m);
        pay.doPayment();
        pay.changeMethod(c);
        pay.removeObserver(e);
        pay.doPayment();
    }
}
