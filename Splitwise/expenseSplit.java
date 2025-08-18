class ExpenseSplit{
    private User user;
    private double amount;

    public ExpenseSplit(User user,double amount){
        this.user=user;
        this.amount=amount;
    }

    public User getUser(){ return user;}
    public double getAmount(){
        return amount;
    }
}