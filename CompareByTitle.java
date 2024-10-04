/*
 * Name: Daniel Rendon
 * Username: drendon10
 * 
 * 
 */

import java.util.Comparator;

public class CompareByTitle implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getTitle().compareToIgnoreCase(book2.getTitle());
    }
}
