# ExpenseManager-project
A simple Java-based Expense Manager application designed to help users track their daily expenses, categorize spending, and view summaries.
This project is built with core Java (Java 12 and below) and uses file-based storage (saving & loading without databases).

📌 Features
✅ Add Expenses
Add expenses with amount, description, category, and date.

✅ View All Expenses
Display all previously saved expenses.

✅ Search / Filter**
Filter expenses by:
Category
Date
Amount range
Keywords in description

✅ Summary View
Total money spent
Spending by category
Highest/lowest expense
Number of entries

✅ Save & Load Data
Saves expenses to a file.
Loads them when program starts.
Built using Java I/O (BufferedReader / BufferedWriter).

📁 Project Structure
ExpenseManager-project/
│
├── src/
│   ├── Expense.java
│   ├── ExpenseManager.java
│   ├── FileHandler.java
│   └── Main.java
│
├── data/
│   └── expenses.txt
│
└── README.md

🛠️ Technologies Used
Java 12 or below
OOP principles (Encapsulation, Abstraction, Inheritance, Polymorphism)
ArrayList
File handling (BufferedReader / BufferedWriter)

🚀 **How to Run**
1. Clone the Repository
gh repo clone Ikedeze/ExpenseManager-project
2. Open in IntelliJ IDEA
Open the folder as a Java project.
Ensure your JDK is properly configured.
3. Compile & Run
Run the main class:
javac Main.java
java Main

OR simply click Run inside IntelliJ.


OR simply click Run inside IntelliJ.
