import java.time.LocalDate;

public class Expense {

    // Expense properties
    private int id;
    private String name;
    private double amount;
    private String category;
    private LocalDate date;

    // Constructor
    public Expense(int id, String name, double amount,
                   String category, LocalDate date) {

        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    // Display expense details
    public void displayExpense() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Category: " + category);
        System.out.println("Date: " + date);
        System.out.println("---------------------------");
    }
}