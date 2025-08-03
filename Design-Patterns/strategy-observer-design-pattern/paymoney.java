
import java.util.ArrayList;

class paymoney {

    payment paymentMethod;
    notification observer;

    ArrayList<notification> allObserver = new ArrayList<>();

    public paymoney(payment payMethod) {
        this.paymentMethod = payMethod;
    }

    void changeMethod(payment payMethod) {
        this.paymentMethod = payMethod;
    }

    void doPayment() {
        paymentMethod.pay();
        notifyObservers();
    }

    void addObserver(notification observer) {
        allObserver.add(observer);
    }

    void removeObserver(notification observer) {
        allObserver.remove(observer);
    }

    void notifyObservers() {
        for (notification elem : allObserver) {
            elem.sendNotification();
        }
    }

}
