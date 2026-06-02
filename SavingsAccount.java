class SavingsAccount extends Account{
    String accountType = "SavingsAccount";
    private int minimumBalance = 100;

    public SavingsAccount(int accountNumber, int balance) {
        super(accountNumber, balance);
    }

    double addInterest() {
        balance += balance * 0.03;
        return balance;
    }

    void Withdraw(int amount){
        if(amount <= 0){
            lastTransaction = "Withdrawal failed. Amount must be positive.";
            return;
        }
        if(balance - amount < minimumBalance){
            lastTransaction = "Withdrawal failed. Savings account must keep at least " + minimumBalance;
            return;
        }
        balance -= amount;
        lastTransaction = "Withdrew " + amount + ". New balance is " + balance;
    }
}
