
import java.util.HashMap;
import java.util.Map;

// User class to manage user information
class User {

    private String userId;
    private String name;
    private String email;
    private Map<User, Double> balances; //Balance with other users

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.balances = new HashMap<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void updateBalance(User user, double amount) {
        balances.merge(user, amount, Double::sum);
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

}
