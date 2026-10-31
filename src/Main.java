import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

ExpenseManager manager = new ExpenseManager();
FileManager fileManager = new FileManager();

// Load previously saved expenses
manager.loadExpenses(fileManager.loadExpenses());

// Generate next available ID
int idCounter = 1;

for (Expense e : manager.getExpenses()) {
    if (e.getId() >= idCounter) {
        idCounter = e.getId() + 1;
    }
}

int choice;
       
        do {
            System.out.println("\n================================");
            System.out.println("     PERSONAL EXPENSE TRACKER");
            System.out.println("================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. View Total Expenses");
            System.out.println("5. View Expenses by Category");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");

if (sc.hasNextInt()) {
    choice = sc.nextInt();
    sc.nextLine();
} else {
    System.out.println("Invalid input! Please enter a number.");
    sc.nextLine();
    choice = 0;
}

            switch (choice) {

                case 1:

                    System.out.print("Enter expense name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    Expense expense = new Expense(
                        idCounter++,
                        name,
                        amount,
                        category,
                        LocalDate.now()
                    );
                    manager.addExpense(expense);
                    fileManager.saveExpenses(manager.getExpenses());
                    break;

                case 2:

                    manager.viewExpenses();

                    break;

                case 3:

                    System.out.print("Enter expense ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteExpense(deleteId);
                    fileManager.saveExpenses(manager.getExpenses());
                    break;
                  case 4:

                    System.out.println(
                        "Total Expenses: Rs. " +
                        manager.calculateTotal()
                    );

                    break;

                case 5:

                    System.out.print("Enter category: ");
                    String searchCategory = sc.nextLine();

                    manager.viewByCategory(searchCategory);

                    break;

                case 6:
                    fileManager.saveExpenses(manager.getExpenses());
System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:

                    System.out.println("Invalid choice! Try again.");

            }

        } while (choice != 6);

        sc.close();
    }
}