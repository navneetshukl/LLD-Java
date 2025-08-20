
import java.util.List;
import java.util.Map;

// Exact amount split expense implementation
class ExactSplitExpense extends Expense {

    private Map<User, Double> amounts;

    public ExactSplitExpense(String expenseId, String description, double amount, User paidBy, List<User> participants, Map<User, Double> amounts) {
        super(expenseId, description, amount, paidBy, participants, SplitMethod.EXACT);
        this.amounts = amounts;
        validateAmounts();
    }

    private void validateAmounts() {
        double totalAmount = amounts.values().stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalAmount - amount) > 0.01) {
            throw new IllegalArgumentException("Exact amounts must sum to total expense amount");
        }
    }

    @Override
    public void splitExpense() {
        for (User participant : participants) {
            if (!participant.equals(paidBy)) {
                double participantShare = amounts.get(participant);
                participant.updateBalance(paidBy, participantShare);
                paidBy.updateBalance(participant, -participantShare);
            }
        }
    }
}
