
import java.util.ArrayList;
import java.util.List;

// Group class to manage group and expenses

class Group{
    private String groupId;
    private String name;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String groupId,String name){
        this.groupId=groupId;
        this.name=name;
        this.members=new ArrayList<>();
        this.expenses=new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        expense.splitExpense();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<User> getMembers() {
        return members;
    }
}