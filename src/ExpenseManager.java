import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

    // Store all expenses
    private ArrayList<Expense> expenses;

    // Constructor
    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    // 1. Add expense
    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added successfully!");
    }

    // 2. View all expenses
    public void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }

        System.out.println("\n===== EXPENSE HISTORY =====");

        for (Expense expense : expenses) {
            expense.displayExpense();
        }
    }

    // 3. Delete expense using ID
    public void deleteExpense(int id) {

        boolean found = false;

        for (int i = 0; i < expenses.size(); i++) {

            if (expenses.get(i).getId() == id) {
                expenses.remove(i);
                System.out.println("Expense deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Expense ID not found!");
        }
    }

    // 4. Calculate total expenses
    public double calculateTotal() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    // 5. View expenses by category
    public void viewByCategory(String category) {

        boolean found = false;

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {
                expense.displayExpense();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category!");
        }
    }

    // 6. Get all expenses
    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }
    public void loadExpenses(List<Expense>loadedExpenses){
        expenses.clear();
        expenses.addAll(loadedExpenses);
    }
}