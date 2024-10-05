/*
 * Name: Daniel Rendon, Joshua Boyer
 * Username: drendon10, joshuab4
 * 
 * 
 */

import java.util.ArrayList;

/*
 * Encapsulation explained: 
 * This class has private instance variables meaning that can't be changed outside 
 * of the class if we handle espacing references. We handle escaping references
 * by creating copies of our data and returning the copies ensuring the actual data
 * is never changed outside of the class.
 *
 * 
 */

public class ReadingList {
    private ArrayList<Book> unreadBooks;
    private ArrayList<Book> readBooks;

    // Constructor for ReadingList
    public ReadingList() {
        unreadBooks = new ArrayList<>();
        readBooks = new ArrayList<>();
    }

    /**
     * Add a book to the unread list
     * 
     * @pre book != null
     *
     */
    public void addUnreadBook(Book book) {
        unreadBooks.add(book);
    }

    /**
     * Set a book to read
     * 
     * 
     * @pre book != null
     *
     */
    public void setToRead(Book book) {
        // check if book exists in the list of unread books
        // if it exists, set it to read by moving it to the read list
        if (unreadBooks.contains(book)) {
            unreadBooks.remove(book);
            readBooks.add(book);
        }
    }

    /**
     * Get a copy of all unread books
     * 
     * @return a list of all unread books
     *
     *
     */
    public ArrayList<Book> getUnreadBooks() {
        ArrayList<Book> allUnread = new ArrayList<>(unreadBooks);
        return allUnread;
    }

    /**
     * Get a copy of all read books
     * 
     * @return a list of all read books
     *
     *
     */
    public ArrayList<Book> getReadBooks() {
        ArrayList<Book> allRead = new ArrayList<>(readBooks);
        return allRead;
    }
}
