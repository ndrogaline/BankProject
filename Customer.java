import java.util.List;

class Customer extends User{
    private int id;
    private String name;
    private List<Account> accounts;
    public boolean isActive;

    public Customer(int id, String name, List<Account> accounts, String username, String password) {
        super(username,password);
        this.id = id;
        this.name = name;
        this.accounts = accounts;
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", accounts=" + accounts +
                '}';
    }
}
