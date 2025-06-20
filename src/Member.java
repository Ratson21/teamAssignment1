public class Member extends User{

    public Member(String userName) {
        super(userName);
    }

    public void interact() {
        System.out.println(name + " sedang menggunakan sistem.");
    }



}
