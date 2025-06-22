
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
        System.out.println("\nBook Lists:");
        for (Book book : books) {
            if (book != null) {
                book.printDetails();
            }
        }
    }

    // Implementasi method removeBook, borrowBook, returnBook disini
    public void removeBook(String title) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) {
                found = true;
                // Geser semua buku setelah yang dihapus ke kiri
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCount] = null; // Kurangi jumlah buku dan hapus duplikat terakhir
                System.out.println("Buku \"" + title + "\" berhasil dihapus.");
                break;
            }
        }

        if (!found) {
            System.out.println("Buku dengan judul \"" + title + "\" tidak ditemukan.");
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
            System.out.println("Buku dengan judul \"" + title + "\" tidak ditemukan.");
        }
    }

}
