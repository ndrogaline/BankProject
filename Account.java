import java.time.LocalDate;

abstract class Account implements ITransaction{
    int accountNumber;
    protected int balance;
    LocalDate dateCreated;
    String lastTransaction = "No transaction yet";

    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateCreated = LocalDate.now();
    }

    void Deposit(int amount){
        if(amount <= 0){
            lastTransaction = "Deposit failed. Amount must be positive.";
            return;
        }
        balance += amount;
        lastTransaction = "Deposited " + amount + ". New balance is " + balance;
    }

    void Withdraw(int amount){
        if(amount <= 0){
            lastTransaction = "Withdrawal failed. Amount must be positive.";
            return;
        }
        if(amount > balance){
            lastTransaction = "Withdrawal failed. Not enough balance.";
            return;
        }
        balance -= amount;
        lastTransaction = "Withdrew " + amount + ". New balance is " + balance;
    }

    public void PrintReceipt(){
        System.out.println(lastTransaction);
    }

    abstract double addInterest();

    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                ", type='" + getClass().getSimpleName() + '\'' +
                '}';
    }
}
