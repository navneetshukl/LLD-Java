
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class EqualExpense extends Expense {

    public EqualExpense(double totalAmount, User paidBy, List<User> involvedUsers, String description, Date expenseDate) {
        super(totalAmount, paidBy, new ArrayList<>(), description, expenseDate);

        double share = totalAmount / involvedUsers.size();
        for (User user : involvedUsers) {
            splits.add(new ExpenseSplit(user, share));

        }
    }
}
