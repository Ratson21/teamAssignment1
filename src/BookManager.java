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
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book != null && book.isAvailable()) {
                book.printDetails();
            }
        }
    }

    // Implementasi method removeBook, borrowBook, returnBook disini
}
