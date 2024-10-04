/*
 * This class implements a book that has an title, author, and rating.
 * It also has a flag to check if the book has been read or not.
 * This 
 * This class is final, which means it is immutable
 * 
 * 
 * 
 * Name: Daniel Rendon, Joshua Boyer
 * Username: drendon10, joshuab4
 * 
 */

/*
* Encapsulation Explained: 
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

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

	@Override
	public String toString() {
		return "\"" + title + "\" By: " + author;
	}
}
