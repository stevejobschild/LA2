/*
 * Daniel Rendon
 * 
 * 
 * 
 */

import java.util.HashMap;

public class Ratings {
    private HashMap<Book, Integer> ratings;

    // Constructor for ratings
    public Ratings() {
        ratings = new HashMap<>();
    }

    /*
     * 
     * 
     * 
     */
    public void setRatingForBook(Book book, int rating) {
        // Since put overrides the previous key, we don't need to check if book has been
        // rated before or not
        ratings.put(book, rating);
    }

    public int getRating(Book book) {
        // may want to check for null, in case book has not been rated before
        int rating = ratings.get(book);
        return rating;
    }

    // hashmap.values to get all ratings of n

}
