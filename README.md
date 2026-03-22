# My Finance App 💰

A lightweight, console-based Java application designed to help users manage their personal finances. Users can register, log in, track their total income, monitor expenses, and forecast their future financial balance.

## 🚀 Features

- **User Authentication:** Secure registration and login system (up to 10 users).
- **Income Management:** Add new income streams to your account.
- **Expense Tracking:** Record and deduct expenses in real-time.
- **Financial Summary:** View a detailed breakdown of your total income, total expenses, and current balance.
- **Future Forecasting:** Calculate your remaining balance after accounting for upcoming/future expenses.

## 📂 Project Structure

- `Main.java`: The entry point of the application. Handles the CLI menus and user interaction.
- `User.java`: The Data Model representing a user profile (Name, Username, Password, Income, Expenses).
- `FinanceManager.java`: The Logic Layer that handles financial calculations and updates user data.
- `My Final.iml`: Project configuration file for IntelliJ IDEA.

## 🛠️ Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher.
- **IDE (Optional):** IntelliJ IDEA, Eclipse, or VS Code.

## 💻 How to Run

1. **Clone the project** or download the source files.
2. **Open your Terminal/Command Prompt** and navigate to the project directory.
3. **Compile the source files:**
   ```bash
   javac Main.java User.java FinanceManager.java
