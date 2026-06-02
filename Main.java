/*
 * BankApp: Single Flow Console Application
 * Main -> Welcome Message -> Authentication/Authorization(Login)
 * 2 stakeholders: Admin, Customer
 * 2 dashboard/menus: AdminMenu, CustomerMenu
 * Operations: CRUD( Add Customer,Delete,Update, Add Account, View All Accounts)
 * Programming and OOD concepts
 * Loops and single flow
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int counter = 1;
    static int accountCounter = 101;
    static List<Customer> customers = new ArrayList<>();
    static List<User> users = new ArrayList<>(); // Users seems kinda pointless if information is stored in customers

    private static final Admin admin = new Admin("admin", "admin123");

    static{
        User u1 = new User("rohit","rohit123");
        User u2 = new User("mohit","mohit123");
        User u3 = new User("shobhit","shobhit123");
        users.add(u1);users.add(u2);users.add(u3);

        Customer c1 = new Customer(counter++, "rohit", new ArrayList<>(),u1.username,u1.password);
        Customer c2 = new Customer(counter++, "mohit", new ArrayList<>(),u2.username,u2.password);
        Customer c3 = new Customer(counter++, "shobhit", new ArrayList<>(),u3.username,u3.password);

        c1.getAccounts().add(new SavingsAccount(accountCounter++, 1000));
        c2.getAccounts().add(new CheckingsAccount(accountCounter++, 1500));
        c3.getAccounts().add(new SavingsAccount(accountCounter++, 800));
        customers.add(c1);  customers.add(c2);  customers.add(c3);
    }


    public static void main(String[] args) {
        welcome();
        String loginResult = login();

        if(loginResult.equals("validation_failed")){
            System.out.println("Validation Failed");
            return;
        }

        if (loginResult.equals(admin.username)){
            adminDashboard();
        }
        else{
            customerDashboard(loginResult);
        }
    }

    private static void customerDashboard(String loginResult) {
        System.out.println("Welcome customer, " + loginResult);
        Customer customer = findCustomerByUsername(loginResult);
        if(customer == null){
            System.out.println("Customer not found");
            return;
        }

        while(true){
            System.out.println("\n1. View accounts");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            System.out.println("Choose option:");

            int choice = readInt();
            switch(choice){
                case 1:
                    viewAccounts(customer.getAccounts());
                    break;
                case 2:
                    doTransaction(customer, true);
                    break;
                case 3:
                    doTransaction(customer, false);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void adminDashboard() {
        System.out.println("Welcome Admin");
        while(true){
            System.out.println("\n1. Create customer and account");
            System.out.println("2. View all customers");
            System.out.println("3. View all accounts");
            System.out.println("4. Add account for customer");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
            System.out.println("Choose option:");

            int choice = readInt();
            switch(choice){
                case 1:
                    createCustomerWithAccount();
                    break;
                case 2:
                    for(Customer customer:customers){
                        System.out.println(customer);
                    }
                    break;
                case 3:
                    for(Customer customer:customers){
                        System.out.println(customer.getName() + ":");
                        viewAccounts(customer.getAccounts());
                    }
                    break;
                case 4:
                    addAccountForCustomer();
                    break;
                case 5:
                    adminTransaction(true);
                    break;
                case 6:
                    adminTransaction(false);
                    break;
                case 7:
                    return;
                case 8:
                    System.out.println("Goodbye");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static String login() {
        System.out.println("Please enter username and password, space separated");
        String enteredUsernamePassword = sc.nextLine();
        //validation can be done
        //rohit rohit123

        String[] usernamePassword = enteredUsernamePassword.trim().split("\\s+");
        if(usernamePassword.length != 2){
            return "validation_failed";
        }
        String username = usernamePassword[0];//rohit
        String password = usernamePassword[1];//rohit123

        if(username.equals(admin.username) && password.equals(admin.password)){
            return admin.username;
        }

        //customer login
        for(User user:users){
            if(user.username.equals(username) && user.password.equals(password)){
                return user.username;
            }
        }

        return "validation_failed";
    }

    private static int readInt() {
        try{
            return Integer.parseInt(sc.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid number");
            return -1;
        }
    }

    private static Customer findCustomerByUsername(String username) {
        for(Customer customer:customers){
            if(customer.username.equals(username)){
                return customer;
            }
        }
        return null;
    }

    private static Customer findCustomerById(int customerId) {
        for(Customer customer:customers){
            if(customer.getId() == customerId){
                return customer;
            }
        }
        return null;
    }

    private static void viewAccounts(List<Account> accounts) {
        if(accounts.isEmpty()){
            System.out.println("No accounts found");
            return;
        }
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    private static void doTransaction(Customer customer, boolean isDeposit) {
        Account account = chooseAccount(customer);
        if(account == null){
            return;
        }

        System.out.println("Enter amount:");
        int amount = readInt();
        if(amount == -1){
            return;
        }

        if(isDeposit){
            account.Deposit(amount);
        }
        else{
            account.Withdraw(amount);
        }
        account.PrintReceipt();
    }

    private static void adminTransaction(boolean isDeposit) {
        System.out.println("Enter customer id:");
        int customerId = readInt();
        if(customerId == -1){
            return;
        }

        Customer customer = findCustomerById(customerId);
        if(customer == null){
            System.out.println("Customer not found");
            return;
        }

        doTransaction(customer, isDeposit);
    }

    private static Account chooseAccount(Customer customer) {
        System.out.println("Enter account number:");
        int accountNumber = readInt();
        if(accountNumber == -1){
            return null;
        }

        for(Account account:customer.getAccounts()){
            if(account.accountNumber == accountNumber){
                return account;
            }
        }

        System.out.println("Account not found");
        return null;
    }

    private static void addAccountForCustomer() {
        System.out.println("Enter customer id:");
        int customerId = readInt();
        if(customerId == -1){
            return;
        }
        Customer customer = findCustomerById(customerId);

        if(customer == null){
            System.out.println("Customer not found");
            return;
        }

        System.out.println("Enter starting balance:");
        int balance = readInt();
        if(balance == -1){
            return;
        }
        System.out.println("Enter type: 1 for savings, 2 for checkings");
        int type = readInt();
        if(type == -1){
            return;
        }

        customer.getAccounts().add(createAccountByType(type, balance));
        System.out.println("Account added");
    }

    private static void createCustomerWithAccount() {
        System.out.println("Enter customer name:");
        String name = sc.nextLine();

        System.out.println("Enter username:");
        String username = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();

        System.out.println("Enter starting balance:");
        int balance = readInt();
        if(balance == -1){
            return;
        }

        System.out.println("Enter type: 1 for savings, 2 for checkings");
        int type = readInt();
        if(type == -1){
            return;
        }

        User user = new User(username, password);
        Customer customer = new Customer(counter++, name, new ArrayList<>(), username, password);
        customer.getAccounts().add(createAccountByType(type, balance));
        users.add(user);
        customers.add(customer);

        System.out.println("Customer and account created");
    }

    private static Account createAccountByType(int type, int balance) {
        if(type == 1){
            return new SavingsAccount(accountCounter++, balance);
        }
        return new CheckingsAccount(accountCounter++, balance);
    }

    private static void welcome() {
        System.out.println("Welcome to ABC Digital Bank");
    }
}
