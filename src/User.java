public class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public void interact() {
        System.out.println(name + " sedang menggunakan sistem.");
    }
}