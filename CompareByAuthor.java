import java.util.Comparator;

public class CompareByAuthor implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getAuthor().compareToIgnoreCase(book2.getAuthor());
    }
}
