public class Book {
    private String title;
    private String author;
    private Boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        if (available) {
            available = false;
            System.out.println("Book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("Book \"" + title + "\" is not available.");
        }
    }

    public void returnBook() {
        available = true;
        System.out.println("Book \"" + title + "\" has been returned.");
    }

    public void printDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + available);
    }

}
