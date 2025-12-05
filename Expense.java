import java.time.LocalDate; // Represents the current date

// Represents one expense entry.
public class Expense {
    private double amount;
    private String category;
    private String description;
    private LocalDate date;

    // Constructor to create the categories for the Expense manager
    public Expense(double amount, String category, String description, LocalDate date){
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory()  {
        return category;
    }

    public String getDescription(){
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + category + " | $" +
        String.format("%.2f", amount) // It makes sure that every decimal number has 2 digits
        + " | " + description; 
    }
}