
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class splitwisedesign {

    public static void main(String[] args) {

        Splitwise splitwise = new Splitwise();

        // Create users
        splitwise.addUser("u1", "Alice", "alice@example.com");
        splitwise.addUser("u2", "Bob", "bob@example.com");
        splitwise.addUser("u3", "Charlie", "charlie@example.com");

        // Create group
        splitwise.createGroup("g1", "Friends Trip");
        splitwise.addUserToGroup("u1", "g1");
        splitwise.addUserToGroup("u2", "g1");
        splitwise.addUserToGroup("u3", "g1");

        // Create equal split expense
        List<User> participants = Arrays.asList(splitwise.getUser("u1"), splitwise.getUser("u2"), splitwise.getUser("u3"));

        Expense equalExpense = new EqualSplitExpense("e1", "Dinner", 90, splitwise.getUser("u1"), participants);
        // Create percentage split expense
        Map<User, Double> percentages = new HashMap<>();
        percentages.put(splitwise.getUser("u1"), 50.0);
        percentages.put(splitwise.getUser("u2"), 30.0);
        percentages.put(splitwise.getUser("u3"), 20.0);
        Expense percentageExpense = new PercentageSplitExpense("e2", "Hotel", 200, splitwise.getUser("u2"), participants, percentages);
        splitwise.addExpense("g1", percentageExpense);

        // Create exact split expense
        Map<User, Double> amounts = new HashMap<>();
        amounts.put(splitwise.getUser("u1"), 50.0);
        amounts.put(splitwise.getUser("u2"), 30.0);
        amounts.put(splitwise.getUser("u3"), 20.0);
        Expense exactExpense = new ExactSplitExpense("e3", "Transport", 100, splitwise.getUser("u3"), participants, amounts);
        splitwise.addExpense("g1", exactExpense);

        // View balances
        System.out.println("Alice's balances: " + splitwise.getUserBalances("u1"));
        System.out.println("Bob's balances: " + splitwise.getUserBalances("u2"));

        // View transaction history
        System.out.println("Alice's transactions: " + splitwise.getUserTransactionHistory("u1"));

        // Settle balance
        splitwise.settleBalance("u1", "u2");
        System.out.println("After settling, Alice's balances: " + splitwise.getUserBalances("u1"));

    }
}
