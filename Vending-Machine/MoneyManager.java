class MoneyManager{
	private double cash;

    public MoneyManager(){
        this.cash=50.0;
    }

    public void addMoney(double amount){
        cash+=amount;
    }

    public double getChange(double changeAmount){
        if(changeAmount<=cash){
            cash-=changeAmount;
            return changeAmount;
        }
        return 0.0; // Not enough cash for change
    }
}