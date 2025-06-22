public class Member extends User {

    public Member(String userName) {
        super(userName);
    }

    @Override
    public void interact() {
        System.out.println(name + " (Member) sedang menggunakan sistem.");
    }
}