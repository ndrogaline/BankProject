class CheckingsAccount extends Account{
    String accountType = "CheckingsAccount";
    private int overdraftLimit = 200;

    public CheckingsAccount(int accountNumber, int balance) {
        super(accountNumber, balance);
    }

    double addInterest() {
        balance += balance * 0.02;
        return balance;
    }

    void Withdraw(int amount){
        if(amount <= 0){
            lastTransaction = "Withdrawal failed. Amount must be positive.";
            return;
        }
        if(balance - amount < -overdraftLimit){
            lastTransaction = "Withdrawal failed. Overdraft limit is " + overdraftLimit;
            return;
        }
        balance -= amount;
        lastTransaction = "Withdrew " + amount + ". New balance is " + balance;
    }
}
