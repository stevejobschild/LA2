/*
 * Name: Daniel Rendon
 * Username: drendon10
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MyLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library myLibrary = new Library();

        while (true) {

            System.out.println("Enter a command - getBooks, suggestRead, addBooks, exit: ");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            }

            /*
             * getBooks command
             */

            if (command.equals("getBooks")) {
                System.out.println("How would you like to sort the books?\nOptions: title, author, read, unread");
                command = scanner.nextLine();
                ArrayList<Book> books = new ArrayList<>();
                while (true) {
                    if (command.equals("title")) {
                        books = new ArrayList<>(myLibrary.sortedByTitle());
                        System.out.println("Here are all books sorted by title:");
                        break;
                    } else if (command.equals("author")) {
                        books = new ArrayList<>(myLibrary.sortedByAuthor());
                        System.out.println("Here are all books sorted by author:");
                        break;
                    } else if (command.equals("read")) {
                        books = new ArrayList<>(myLibrary.sortReadBooks());
                        System.out.println("Here are all read books sorted by title:");
                        break;
                    } else if (command.equals("unread")) {
                        books = new ArrayList<>(myLibrary.sortUnreadBooks());
                        System.out.println("Here are all unread books sorted by title:");
                        break;
                    } else {
                        System.out.println("Enter a valid input!\n");
                    }
                }

                for (Book book : books) {
                    System.out.println(book.getTitle() + " - " + book.getAuthor());
                }

            } else if (command.equals("suggestRead")) {
                /*
                 * suggestRead command
                 */
                Book randomBook = myLibrary.suggestRead();
                System.out.println("you should read: \n" + randomBook.getTitle() + " - " +
                        randomBook.getAuthor() + "\n");
            } else if (command.equals("addBooks")) {
                /*
                 * addBooks command
                 */
                System.out.print("Enter filename: ");
                String filename = scanner.nextLine();
                myLibrary.addBooksFromFile(filename);

            } else {
                System.out.println("Enter a valid command!\n");
            }

        }

        scanner.close();

    }
}
