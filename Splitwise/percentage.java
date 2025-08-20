
import java.util.List;
import java.util.Map;

// Percentage split expense implementation
class PercentageSplitExpense extends Expense {

    private Map<User, Double> percentages;

    public PercentageSplitExpense(String expenseId, String description, double amount, User paidBy, List<User> participants, Map<User, Double> percentages) {
        super(expenseId, description, amount, paidBy, participants, SplitMethod.PERCENTAGE);
        this.percentages = percentages;
        validatePercentages();
    }

    private void validatePercentages() {
        double totalPercentage = percentages.values().stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalPercentage - 100.0) > 0.01) {
            throw new IllegalArgumentException("Percentages must sum to 100");

        }
    }

    @Override
    public void splitExpense() {
        for (User participant : participants) {
            if (!participant.equals(paidBy)) {
                double participantShare = amount * (percentages.get(participant) / 100);
                participant.updateBalance(paidBy, participantShare);
                paidBy.updateBalance(participant, -participantShare);
            }
        }
    }
}
