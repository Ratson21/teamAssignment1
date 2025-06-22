public class Book {
    private String title;
    private String author;
    private boolean borrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrow() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("Book \"" + title + "\" is not available.");
        }
    }

    public void returnBook() {
        borrowed = false;
        System.out.println("Book \"" + title + "\" has been returned.");
    }

    public void printDetails() {
        String status = borrowed ? "Booked" : "Available";
        System.out.println("Title: " + title + ", Author: " + author + ", Status: " + status);
    }
}