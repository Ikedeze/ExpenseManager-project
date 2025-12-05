import java.time.LocalDate;

public class ExpenseManagerTest {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();

        manager.addExpense(new Expense(15.0, "Transport", "Bus ticket", LocalDate.now()));
        manager.addExpense(new Expense(40.5, "Food", "Groceries", LocalDate.now()));

        System.out.println("All Expenses:");
        manager.listExpenses();
        
        System.out.println("Total: $" + manager.getTotalExpenses());
    }
    
}
