
import java.util.Scanner;

public class Perpustakaan {

    private final BookManager bookManager;
    private final Scanner scanner;

    public Perpustakaan() {
        this.bookManager = new BookManager();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        User user = login();
        user.interact();

        boolean exit = false;
        while (!exit) {
            displayMenu(user);
            exit = handleMenuChoice(user);
        }

        System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
    }

    private User login() {
        User user = null;
        while (user == null) {
            System.out.println("--- Welcome to the Library System ---");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Nama tidak boleh kosong. Silakan coba lagi.");
            } else {
                System.out.print("Login as Admin or Member? (A/M): ");
                String role = scanner.nextLine().trim().toUpperCase();

                if (role.isEmpty() || (!role.equals("A") && !role.equals("M"))) {
                    System.out.println("Role tidak valid. Masukkan 'A' untuk Admin atau 'M' untuk Member.");
                } else {
                    user = role.equals("A") ? new Admin(name) : new Member(name);
                }
            }
        }
        return user;
    }

    private void displayMenu(User user) {
        System.out.println("\n--- Menu ---");
        if (user instanceof Admin) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
        } else {
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
        }
        System.out.println("3. Show Available Books");
        System.out.println("0. Exit");
    }

    private boolean handleMenuChoice(User user) {
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                handleOption1(user);
                break;
            case 2:
                handleOption2(user);
                break;
            case 3:
                bookManager.displayAvailableBooks();
                break;
            case 0:
                return true;
            default:
                System.out.println("Pilihan tidak valid.");
        }
        return false;
    }

    private void handleOption1(User user) {
        if (user instanceof Admin) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            bookManager.addBook(new Book(title, author));
        } else {
            System.out.print("Enter title to borrow: ");
            String borrowTitle = scanner.nextLine();
            bookManager.borrowBook(borrowTitle);
        }
    }

    private void handleOption2(User user) {
        if (user instanceof Admin) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            bookManager.removeBook(title);
        } else {
            System.out.print("Enter title to return: ");
            String returnTitle = scanner.nextLine();
//            bookManager.returnBook(returnTitle);
        }
    }

    public static void main(String[] args) {
        new Perpustakaan().start();
    }
}
