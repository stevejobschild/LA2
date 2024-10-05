/*
 * 
 * Name: Daniel Rendon, Joshua Boyer
 * Username: drendon10, joshuab4
 * 
 * 
 * 
 * Encapsulation Explained: 
 * This book class achieves encapsulation as it is created to 
 * be immutable. The class is declared final to indicate this.
 * The instance variables are set as private to make sure 
 * they are not changed outside of the class. In addition to that,
 * these variables also can't be changed through any methods inside
 * the class. There is only getters and we don't have to worry about 
 * escaping references since strings are immutable.
 * 
 * 
 * 
 */

public final class Book {
    // Immutable class

    // Instance variables
    private String title;
    private String author;

    // Constructor
    public Book(String t, String a) {
        title = t;
        author = a;
    }

    /**
     * Getter for title
     * 
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for author
     * 
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" By: " + author;
    }
}
