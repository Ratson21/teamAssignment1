public class Admin extends User{

    public Admin(String userName) {
        super(userName);
    }

    public void interact() {
        System.out.println(name + " sedang menggunakan sistem.");
    }


}
