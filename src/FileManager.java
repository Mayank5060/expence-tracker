import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final String fileName = "expenses.txt";

    public void saveExpenses(List<Expense> expenses) {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(fileName))) {

            for (Expense expense : expenses) {

                writer.write(
                    expense.getId() + "|" +
                    expense.getName().replace("|", "/") + "|" +
                    expense.getAmount() + "|" +
                    expense.getCategory().replace("|", "/") + "|" +
                    expense.getDate()
                );

                writer.newLine();
            }

            System.out.println("Expenses saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    public List<Expense> loadExpenses() {

        List<Expense> expenses = new ArrayList<>();

        File file = new File(fileName);

        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader =
                new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {
                    String[] data = line.split("\\|", -1);

                    if (data.length != 5) {
                        continue;
                    }

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double amount = Double.parseDouble(data[2]);
                    String category = data[3];
                    LocalDate date = LocalDate.parse(data[4]);

                    expenses.add(new Expense(
                        id, name, amount, category, date
                    ));

                } catch (RuntimeException e) {
                    System.out.println("Skipping invalid expense record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }

        return expenses;
    }
}