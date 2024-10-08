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
 * 
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
     * @return the rating for a book
     * 
     *
     */
    public int getRating(Book book) {
        // may want to check for null, in case book has not been rated before
        int rating = ratings.get(book);
        return rating;
    }

    // hashmap.values to get all ratings of n
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
