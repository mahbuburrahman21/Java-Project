// FinanceManager.java
public class FinanceManager {
    private User user;

    // Constructor
    public FinanceManager(User user) {
        this.user = user;
    }

    // Method to add income
    public void addIncome(double amount) {
        user.setTotalIncome(user.getTotalIncome() + amount);
    }

    // Method to deduct expenses
    public void deductExpenses(double amount) {
        user.setTotalExpenses(user.getTotalExpenses() + amount);
    }

    // Method to calculate remaining balance
    public double calculateRemainingBalance() {
        return user.getTotalIncome() - user.getTotalExpenses();
    }

    // Method to calculate future expenses and remaining balance
    public double calculateFutureExpensesAndBalance(double futureExpenses) {
        double totalExpensesIncludingFuture = user.getTotalExpenses() + futureExpenses;
        return user.getTotalIncome() - totalExpensesIncludingFuture;
    }
}
