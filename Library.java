/*
 * Name: Daniel Rendon
 * Username: drendon10
 * 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/*
 * Encapsulation Explained: 
 * 
 * 
 */
public class Library {

    // Instance Variables
    private ArrayList<Book> library;
    private ReadingList readingList;
    private Ratings ratings;

    // Constructor for Library
    public Library() {
        library = new ArrayList<>();
        library.add(new Book("Great Beyond", "Harold Gerald"));
        readingList = new ReadingList();
        ratings = new Ratings();
    }

    /**
     * Adds book to the library and it also adds it to the list of unread books
     * 
     * @pre title != null && author != null
     *
     */
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        readingList.addUnreadBook(book);
        library.add(book);
    }

    /**
     * Sets a book to read
     * 
     * @pre book != null
     *
     */
    public void setToRead(Book book) {
        readingList.setToRead(book);
    }

    /**
     * Set rating for a specific book
     * 
     * @pre book != null && title == (int from 1-5)
     *
     */
    public void setRating(Book book, int rating) {
        ratings.setRatingForBook(book, rating);
    }

    /**
     * Get all books by a certain author
     * 
     * @return All books by author
     * 
     * @pre author != null
     *
     */
    public ArrayList<Book> booksByAuthor(String author) {
        ArrayList<Book> booksByAuth = new ArrayList<>();
        for (Book book : library) {
            if (book.getAuthor().equals(author)) {
                booksByAuth.add(book);
            }
        }
        return booksByAuth;
    }
    
    // Get all books by a title
    public ArrayList<Book> booksByTitle(String title) {
        ArrayList<Book> booksByTitle = new ArrayList<>();
        for (Book book : library) {
            if (book.getTitle().equals(title)) {
            	booksByTitle.add(book);
            }
        }
        return booksByTitle;
    }
    
    // Get all books by a rating
    public ArrayList<Book> booksByRating(int rating) {
        return ratings.getBooksWithRating(rating);
    }

    /**
     * Get a book specified by the parameters title and author
     * 
     * @return a specific book in the library
     * 
     * @pre library.contains(book) && title != null && author != null
     * 
     * @throws NoSuchElementException if book is not in the library
     */
    public Book getBook(String title, String author) {
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * This method creates and returns a copy of the library that is sorted
     * using a class that implements Comparator to sort by Author in alphabetical
     * order
     * 
     * @return ArrayList<Book>
     * 
     */
    public ArrayList<Book> sortedByAuthor() {
        // create a copy of the library to avoid escaping references
        ArrayList<Book> sortedByAuthor = new ArrayList<>(library);
        Collections.sort(sortedByAuthor, new CompareByAuthor());
        return sortedByAuthor;
    }

    /**
     * This method creates and returns a copy of the library that is sorted
     * using a class that implements Comparator to sort by Title in alphabetical
     * order
     * 
     * @return ArrayList<Book>
     * 
     *
     */
    public ArrayList<Book> sortedByTitle() {
        // create a copy of the library to avoid escaping references
        ArrayList<Book> sortedByTitle = new ArrayList<>(library);
        Collections.sort(sortedByTitle, new CompareByTitle());
        return sortedByTitle;
    }
    
    /**
     * This method creates and returns a copy of the read books that is
     * sorted using a class that implemets Comparator to sort by Title in
     * alphabetical order
     * 
     * @return ArrayList<Book>
     * 
     *
     */
    public ArrayList<Book> sortReadBooks() {
        // create a copy of the unread books to avoid escaping references
        ArrayList<Book> sortedByTitle = new ArrayList<>(readingList.getReadBooks());
        Collections.sort(sortedByTitle, new CompareByTitle());
        return sortedByTitle;
    }
    /**
     * This method creates and returns a copy of the unread books that is sorted
     * using a class that implements Comparator to sort by Title in alphabetical
     * order
     * 
     * @return ArrayList<Book>
     * 
     *
     */
    public ArrayList<Book> sortUnreadBooks() {
        // create a copy of the unread books to avoid escaping references
        ArrayList<Book> sortedByTitle = new ArrayList<>(readingList.getUnreadBooks());
        Collections.sort(sortedByTitle, new CompareByTitle());
        return sortedByTitle;
    }
    /**
     * This method returns a random book from the unread list of books
     * 
     * @return a suggested book
     * 
     * 
     */
    public Book suggestRead() {
        ArrayList<Book> unread = new ArrayList<>(readingList.getUnreadBooks());
        if (unread.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randInd = random.nextInt(unread.size());
        return unread.get(randInd);
    }
    /**
     * This method takes in a filename and uses a try and catch to add all the books
     * in the file to the library using the addBook method
     * 
     * 
     * @pre filename is a valid filename and its data is formatted: (Title;Author)
     * 
     * @throws FileNotFoundException when there has been an error reading the file
     *
     */
    public void addBooksFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            // skip first line that has "Title;Author"
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] content = line.split(";");
                if (content.length == 2) {
                    String title = content[0].trim();
                    String author = content[1].trim();
                    addBook(title, author);
                }
            }
            fileScanner.close();
            System.out.println("Books added successfully!\n");
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file!\n");
        }
    }

}
