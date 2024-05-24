import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static final int MAX_USERS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User interface
        System.out.println("Welcome to My Finance App!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
              System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    User user = login(scanner);
                    if (user != null) {
                        FinanceManager financeManager = new FinanceManager(user);
                        userMenu(scanner, user, financeManager);
                    }
                    break;
                case 2:
                    if (users.size() < MAX_USERS) {
                        User newUser = register(scanner);
                        if (newUser != null) {
                            users.add(newUser);
                        }
                    } else {
                        System.out.println("User registration limit reached.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting My Finance App. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }

    private static void userMenu(Scanner scanner, User user, FinanceManager financeManager) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nUser Menu:");
            System.out.println("1. Show financial condition");
            System.out.println("2. Add new income");
            System.out.println("3. Deduct expenses");
            System.out.println("4. Calculate future expenses and remaining balance");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nFinancial Condition:");
                    System.out.println("Total Income: $" + user.getTotalIncome());
                    System.out.println("Total Expenses: $" + user.getTotalExpenses());
                    System.out.println("Remaining Balance: $" + financeManager.calculateRemainingBalance());
                    break;
                case 2:
                    System.out.print("\nEnter amount of new income: $");
                    double income = scanner.nextDouble();
                    financeManager.addIncome(income);
                    System.out.println("Income added successfully.");
                    break;
                case 3:
                    System.out.print("\nEnter amount of expenses to deduct: $");
                    double expenses = scanner.nextDouble();
                    financeManager.deductExpenses(expenses);
                    System.out.println("Expenses deducted successfully.");
                    break;
                case 4:
                    System.out.print("\nEnter amount of future expenses: $");
                    double futureExpenses = scanner.nextDouble();
                    double remainingBalance = financeManager.calculateFutureExpensesAndBalance(futureExpenses);
                    System.out.println("After deducting future expenses, remaining balance will be: $" + remainingBalance);
                    break;
                case 5:
                    exit = true;
                    System.out.println("\nLogged out successfully.");
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }

    // Method to handle user registration
    private static User register(Scanner scanner) {
        System.out.println("\nUser Registration:");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter desired username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter total income: $");
        double totalIncome = scanner.nextDouble();
        System.out.print("Enter total expenses: $");
        double totalExpenses = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // Check if the username is already taken
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already taken. Please try a different one.");
                return null;
            }
        }

        return new User(name, username, password, totalIncome, totalExpenses);
    }

    // Method to handle user login
    private static User login(Scanner scanner) {
        System.out.println("\nUser Login:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
        return null;
    }
}
