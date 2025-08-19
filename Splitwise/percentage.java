
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

class PercentageExpense extends Expense{
    public PercentageExpense(double totalAmount,User paidBy,Map<User,Double> userToPercent,String description,Date expenseDate){
        super(totalAmount, paidBy, new ArrayList<>(), description, expenseDate);

        for(Map.Entry<User,Double>entry: userToPercent.entrySet()){
            splits.add(new ExpenseSplit(entry.getKey(),totalAmount*entry.getValue()/100));
        }

        double totalPercent=userToPercent.values().stream().mapToDouble(Double::doubleValue).sum();
        if(totalPercent!=100) throw new IllegalArgumentException("Total percent Must be 100");
    }
}