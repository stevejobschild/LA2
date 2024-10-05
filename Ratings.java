/*
 * Name: Daniel Rendon, Joshua Boyer
 * Username: drendon10, joshuab4
 * 
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Encapsulation Explained: 
 * This class achieves encapsulation in different ways.
 * The instance variable is private and can only be changed through
 * the class' methods. We handle espacing references by creating
 * new ArrayLists with the values we want. We don't have to worry about the 
 * books because they are immutable.
 * 
 */
public class Ratings {
    private HashMap<Book, Integer> ratings;

    // Constructor for ratings
    public Ratings() {
        ratings = new HashMap<>();
    }

    /**
     * Set rating for a specific book
     * 
     * @pre book != null && rating == (int 1-5)
     *
     * 
     */
    public void setRatingForBook(Book book, int rating) {
        // Since put overrides the previous key, we don't need to check if book has been
        // rated before or not
        ratings.put(book, rating);
    }

    /**
     * Returns the rating for a specific book
     * 
     * @pre book != null
     * 
     * @return the rating for a book
     * 
     *
     */
    public int getRating(Book book) {
        int rating = ratings.get(book);
        return rating;
    }

    /**
     * Returns all books with a specific rating
     * 
     * @pre rating is an int 1-5
     * 
     * @return the books that have that specific rating
     * 
     *
     */
    public ArrayList<Book> getBooksWithRating(int rating) {
        ArrayList<Book> matchingBooks = new ArrayList<Book>();
        for (Entry<Book, Integer> entry : ratings.entrySet()) {
            if (entry.getValue() == rating) {
                matchingBooks.add(entry.getKey());
            }
        }

        return matchingBooks;
    }
}
