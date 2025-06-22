public class Admin extends User {

    public Admin(String userName) {
        super(userName);
    }

    @Override
    public void interact() {
        System.out.println(name + " (Admin) sedang menggunakan sistem.");
    }
}