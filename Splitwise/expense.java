
import java.util.Date;
import java.util.List;

class Expense {

    protected double totalAmount;
    protected User paidBy;
    protected List<ExpenseSplit> splits;
    protected String description;
    protected Date expenseDate;

    public Expense(double totalAmount,User paidBy,List<ExpenseSplit> splits,String description,Date expenseDate){
        this.totalAmount=totalAmount;
        this.paidBy=paidBy;
        this.splits=splits;
        this.description=description;
        this.expenseDate=expenseDate;
    }

}
