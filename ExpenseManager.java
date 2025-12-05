import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Manages a collection of expenses
public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();

    // It adds expenses to the list
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // It shows a condition of whether the list is empty or not
    public void listExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }
    }

    // To get the total sum of expenses
    public double getTotalExpenses1() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }
    
    // Using BufferedWriter we use it to save and write data into a file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (Expense e : expenses) {
                String line = e.getAmount() + "," + e.getCategory() + "," + e.getDescription() + 
                "," + e.getDate();
                writer.write(line);
                writer.newLine();
              }
              System.out.println("Expenses saved succesfully to " + filename); 
        } catch (IOException ex) {
            System.out.println("Error saving file: " + ex.getMessage());
        }
        
    }

    // Using BufferedReader we use it to load a saved file
    public void loadFromFile(String filename) {
        expenses.clear(); //clear old list before loading
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    double amount = Double.parseDouble(parts[0]);
                    String category = parts[1];
                    String description = parts[2];
                    LocalDate date = LocalDate.parse(parts[3]); 
                    expenses.add(new Expense(amount, category, description, date));
                }
            }
            System.out.println("Expenses loaded successfully from " + filename);
        } catch (IOException ex) {
            System.out.println("Error loading file: " + ex.getMessage());
        }
    }

    //Simply to filter by category with conditions and loops sha
    public void filterByCategory(String category) {
        System.out.println("\nExpenses in category: " + category);
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found in this category");
        }
    }

    // Filter by date
    public void filterByDateRange(LocalDate start, LocalDate end) {
        System.out.println("\nExpenses between " + start + " and " + end + ":");
        boolean found = false;
        for (Expense e: expenses) {
            if ((e.getDate().isAfter(start.minusDays(1))) && 
            (e.getDate().isBefore(end.plusDays(1)))) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found in this date range.");
        }
    }

    //Filter by description or whatever
    public void searchByKeyword(String keyword) {
        System.out.println("\nSearch results for: \"" + keyword + "\"");
        boolean found = false;
        for (Expense e : expenses) {
            if (e.getDescription().toLowerCase().contains(keyword.toLowerCase())){
                 System.out.println(e);
                 found = true;
            }
        }
        if (!found) {
            System.out.println("No matching expenses found.");
        }
    }

    // Beginning of the Category summary(Total Expenses)
    public double getTotalExpenses() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    //(Average Expenses)
    public double getAverageExpense() {
        if (expenses.isEmpty()) {
            return 0;
        }
        return getTotalExpenses() / expenses.size();
    }

    //Ending of the Category summary(Total for each category). Using HashMap and Mapping
    public void showCategorySummary() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to summarize.");
            return;
        }

        Map<String, Double> categoryTotals = new HashMap<>();
        
        for (Expense e : expenses) {
            String category = e.getCategory();
            double amount = e.getAmount();
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);
        }

        System.out.println("\n====== Expense Summary =======");
        System.out.println("Total Expenses: $" + String.format("%.2f", getTotalExpenses()));
        System.out.println("Average Expenses: $" + String.format("%.2f", getAverageExpense()));
        System.out.println("-----------------------------------");

        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.println(entry.getKey() + ": $" + String.format("%.2f", entry.getValue()));
        }
    }
}


















