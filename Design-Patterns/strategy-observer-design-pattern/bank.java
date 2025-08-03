class bank implements  payment {

    String toAccount;
    int amount;

    public bank(String toAccount, int amount) {
        this.toAccount = toAccount;
        this.amount = amount;
    }

@Override
    public void pay() {
        System.out.println("Paying From Bank Total Amount " + amount + " to " + toAccount);
    }
}
