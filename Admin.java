class Admin extends User{
    int id;
    String username = "admin";
    String password = "admin123";

    public Admin(String username, String password) {
        super(username, password);
    }
}
