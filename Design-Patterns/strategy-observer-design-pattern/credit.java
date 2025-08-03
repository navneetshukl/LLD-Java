
class credit implements payment {

    String cardNumber;
    int amount;

    public credit(String cardNumber, int amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Paying From Credit Card Total Amount " + amount + " to " + cardNumber);

    }

}
