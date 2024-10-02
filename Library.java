/*
 * Daniel Rendon
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Library {

    // Instance Variables
    private ArrayList<Book> library;
    private ReadingList readingList;
    private Ratings ratings;

    // Constructor for Library
    public Library() {
        library = new ArrayList<Book>();
        readingList = new ReadingList();
        ratings = new Ratings();

    }

    // Add book to the library

    public void addBook(Book book) {
        readingList.addUnreadBook(book);
        library.add(book);
    }

    // Set book to read
    public void setToRead(Book book) {
        readingList.setToRead(book);
    }

    // Set rating for book
    public void setRating(Book book, int rating) {
        ratings.setRatingForBook(book, rating);
    }

    // Get all books by an author
    public ArrayList<Book> booksByAuthor(String author) {
        ArrayList<Book> booksByAuth = new ArrayList<>();
        for (Book book : library) {
            if (book.getTitle().equals(author)) {
                booksByAuth.add(book);
            }
        }
        return booksByAuth;
    }

    /*
     * This method returns a specific book in the libary.
     * It assumes that the book actually exists in the library, otherwise
     * it will have to return null which we DO NOT want.
     */
    public Book getBook(String title, String author) {
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    /*
     * Get all books by rating
     * 
     */

    /*
     * Returns a copy of the books in the library sorted by author
     * in alphabetical order using a Comparator class.
     */
    public ArrayList<Book> sortedByAuthor() {
        // create a copy of the library to avoid escaping references
        ArrayList<Book> sortedByAuthor = new ArrayList<>(library);
        Collections.sort(sortedByAuthor, new CompareByAuthor());
        return sortedByAuthor;
    }

    /*
     * Returns a copy of the books in the library sorted by title
     * in alphabetical order using a Comparator class.
     */
    public ArrayList<Book> sortedByTitle() {
        // create a copy of the library to avoid escaping references
        ArrayList<Book> sortedByTitle = new ArrayList<>(library);
        Collections.sort(sortedByTitle, new CompareByTitle());
        return sortedByTitle;
    }

}
