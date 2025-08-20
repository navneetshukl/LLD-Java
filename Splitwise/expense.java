
import java.util.List;

// Expense class to manage expense details
abstract class Expense {

    protected String expenseId;
    protected String description;
    protected double amount;
    protected User paidBy;
    protected List<User> participants;
    protected SplitMethod splitMethod;

    public Expense(String expenseId, String description, double amount, User paidBy, List<User> participants, SplitMethod splitMethod) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.participants = participants;
        this.splitMethod = splitMethod;

    }

    public abstract void splitExpense();

    public String getExpenseId() {
        return expenseId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<User> getParticipants() {
        return participants;
    }
}
