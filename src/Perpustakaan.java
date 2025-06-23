import java.util.Scanner;

public class Perpustakaan {

    private final BookManager bookManager;
    private final Scanner scanner;

    public Perpustakaan(BookManager bookManager) {
        this.bookManager = bookManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exitApp = false;
        while (!exitApp) {
            User user = login();
            user.interact();

            boolean logout = false;
            while (!logout) {
                displayMenu(user);
                logout = handleMenuChoice(user);
            }

            System.out.print("Logout sukses. Ingin keluar aplikasi? (Y/N): ");
            String response = scanner.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                exitApp = true;
            }
        }

        System.out.println("Terima kasih telah menggunakan sistem perpustakaan!");
    }

    private User login() {
        User user = null;
        while (user == null) {
            System.out.println("\n--- Login ---");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
            } else {
                System.out.print("Login as Admin or Member? (A/M): ");
                String role = scanner.nextLine().trim().toUpperCase();

                if (role.equals("A")) {
                    user = new Admin(name);
                } else if (role.equals("M")) {
                    user = new Member(name);
                } else {
                    System.out.println("Input tidak valid.");
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
        System.out.println("0. Logout");
    }

    private boolean handleMenuChoice(User user) {
        System.out.print("Choose: ");
        try {
            String input = scanner.nextLine().trim();
            // Coba konversi input ke integer
            int choice = Integer.parseInt(input);
        
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
                    return true; // logout
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih angka 0-3.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
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
            bookManager.returnBook(returnTitle);
        }
    }

    public static void main(String[] args) {
        BookManager sharedBookManager = new BookManager();
        new Perpustakaan(sharedBookManager).start();
    }
}