import java.time.LocalDate;
import java.util.Scanner;


// Entry point for the Personal Expense Tracker.
public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. List Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Exit");
            System.out.println("5. Save Expenses");
            System.out.println("6. Load Expenses");
            System.out.println("7. Filter by Category");
            System.out.println("8. Filter by Date Range");
            System.out.println("9. Search by Keyword");
            System.out.println("10. View Expense Summary");
            System.out.println("Enter choice: ");
            int choice = scanner.nextInt(); // clear newline
            scanner.nextLine();  // So that it won't ignore the scanner in choice 7-9

            if (choice == 1) {
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter category: ");
                String category = 
                scanner.nextLine();

                System.out.print("Enter description: ");
                String description = 
                scanner.nextLine();

                System.out.print("Enter date (yyyy-mm-dd): ");
                String dateString = 
                scanner.nextLine();
                LocalDate date =
                LocalDate.parse(dateString); //To put a variable with supposed "Method date" numbers into the methods or DIR

                Expense e = new Expense(amount, category, description, date);
                manager.addExpense(e);
                System.out.println("Expense added succesfully!");
            }
            else if (choice == 2) {
                System.out.println("\n--- All Expense ---");
                manager.listExpenses();
            }
            else if (choice == 3){ 
                System.out.println("Total Expenses: $" + 
                String.format("%.2f", manager.getTotalExpenses1()));
            }
            else if (choice == 4) {
                System.out.println("Exiting... Goodbye!");
                break;
            }
             else if (choice == 5){
               manager.saveToFile("expenses.txt");
            }
             else if (choice == 6){
               manager.loadFromFile("expenses.txt");
             }
             else if (choice == 7){
                System.out.println("Enter category: ");
                String category = scanner.nextLine();
                manager.filterByCategory(category);
             }
             else if (choice == 8){
                System.out.println("Enter start date (YYYY-MM-DD): ");
                LocalDate start = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter end date (YYYY-MM-DD): ");
                LocalDate end = LocalDate.parse(scanner.nextLine());
                manager.filterByDateRange(start, end);
             }
             else if (choice == 9){ 
                System.out.println("Enter keyword to search: ");
                String keyword = scanner.nextLine();
                manager.searchByKeyword(keyword);
             }
             else if (choice == 10) {
                manager.showCategorySummary();
             }
            else{ 
                System.out.println("Invalid choice. Please try again. ");
            }

        }
        scanner.close();
    }
}