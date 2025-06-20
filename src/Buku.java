public class Buku {
    private String title;
    private String author;
    private Boolean available;

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
