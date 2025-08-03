
class upi implements payment {

    String upiId;
    int amount;

    public upi(String upiId, int amount) {
        this.upiId = upiId;
        this.amount = amount;
    }

    @Override
    public void pay() {
        System.out.println("Paying From UPI Total Amount " + amount + " to " + upiId);

    }

}
