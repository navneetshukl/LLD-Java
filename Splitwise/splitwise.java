
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Splitwise class to manage the overall system
class Splitwise {

    private Map<String, User> users;
    private Map<String, Group> groups;
    private List<Expense> allExpenses;

    public Splitwise() {
        this.users = new HashMap<>();
        this.groups = new HashMap<>();
        this.allExpenses = new ArrayList<>();
    }

    public void addUser(String userId, String name, String email) {
        users.put(userId, new User(userId, name, email));
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void createGroup(String groupId, String name) {
        groups.put(groupId, new Group(groupId, name));
    }

    public void addUserToGroup(String userId, String groupId) {
        User user = users.get(userId);
        Group group = groups.get(groupId);
        if (users != null && group != null) {
            group.addMember(user);
        }
    }

    public void addExpense(String groupId, Expense expense) {
        Group group = groups.get(groupId);
        if (group != null && group.getMembers().containsAll(expense.getParticipants())) {

            group.addExpense(expense);
            allExpenses.add(expense);
        } else {
            throw new IllegalArgumentException("Invalid group or participants");
        }

    }

    public Map<User, Double> getUserBalances(String userId) {
        User user = users.get(userId);
        return user != null ? user.getBalances() : new HashMap<>();
    }
}
