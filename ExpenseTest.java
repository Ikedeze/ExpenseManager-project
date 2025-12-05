import java.time.LocalDate;

public class ExpenseTest {
    public static void main(String[] args) {
        Expense e = new Expense(12.5, "Food", "Lunch", 
        LocalDate.of(2025, 9, 15)); // You can edit the current date with this code 
        System.out.println(e);
    }
    
}
