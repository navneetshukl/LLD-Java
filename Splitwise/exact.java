
import java.util.Date;
import java.util.List;


class ExactExpense extends Expense {

    public ExactExpense(double totalAmount, User paidBy, List<ExpenseSplit> splits, String description, Date expenseDate) {
        super(totalAmount, paidBy, splits, description, expenseDate);
        double totalSplit = splits.stream().mapToDouble(ExpenseSplit::getAmount).sum();
        if (totalSplit != totalAmount) {
            throw new IllegalArgumentException("Exact split amounts must total expense amount");
        }
    }
}
