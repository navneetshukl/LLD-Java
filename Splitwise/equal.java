
import java.util.List;

// Equal split expense implementation
class EqualSplitExpense extends Expense {

    public EqualSplitExpense(String expenseId, String description, double amount, User paidBy, List<User> participants) {
        super(expenseId, description, amount, paidBy, participants, SplitMethod.EQUAL);
    }

    @Override
    public void splitExpense() {
        double splitAmount = amount / participants.size();
        for (User participant : participants) {
            if (!participant.equals(paidBy)) {
                participant.updateBalance(paidBy, splitAmount);
                paidBy.updateBalance(participant, -splitAmount);
            }
        }
    }

}
