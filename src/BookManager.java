public class BookManager {

    private final Book[] books;
    private int bookCount;

    public BookManager() {
        this.books = new Book[100];
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Added book: " + book.getTitle());
        } else {
            System.out.println("Book list is full.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("\nBook List:");
        for (Book book : books) {
            if (book != null) {
                book.printDetails();
            }
        }
    }

    public void removeBook(String title) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) {
                found = true;
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCount] = null;
                System.out.println("Book \"" + title + "\" removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("Book \"" + title + "\" not found.");
        }
    }

    public void borrowBook(String title) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) {
                found = true;
                books[i].borrow();
                break;
            }
        }

        if (!found) {
            System.out.println("Book \"" + title + "\" not found.");
        }
    }

    public void returnBook(String title) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) {
                found = true;
                if (books[i].isBorrowed()) {
                    books[i].returnBook();
                } else {
                    System.out.println("Book \"" + title + "\" is not currently borrowed.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Book \"" + title + "\" not found.");
        }
    }
}