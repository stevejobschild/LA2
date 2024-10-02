/*
 * Daniel Rendon
 * 
 * 
 * 
 */

import java.util.ArrayList;

public class ReadingList {
    private ArrayList<Book> unreadBooks;
    private ArrayList<Book> readBooks;

    // Constructor for ReadingList
    public ReadingList() {
        unreadBooks = new ArrayList<>();
        readBooks = new ArrayList<>();
    }

    // Constructor for passing in a full library of books
    public ReadingList(ArrayList<Book> library) {
        unreadBooks = new ArrayList<>(library);
        readBooks = new ArrayList<>();
    }

    // Add a new book to the unread list
    public void addUnreadBook(Book book) {
        unreadBooks.add(book);
    }

    // Set a book to read
    public void setToRead(Book book) {
        // check if book exists in the list of unread books
        // if it exists, set it to read by moving it to the read list
        if (unreadBooks.contains(book)) {
            unreadBooks.remove(book);
            readBooks.add(book);
        }
    }

    // get unread book
    /*
     * 
     * 
     * 
     */

    // get read book
    /*
     * 
     * 
     * 
     */
}
