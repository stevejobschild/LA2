/*
 * Name: Daniel Rendon, Joshua Boyer
 * Username: drendon10, joshuab4
 * 
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class MyLibrary {

	public static void main(String[] args) {

		Library library = new Library();

		// print welcome messages
		System.out.println("Welcome! Available commands for our library include: ");
		System.out.println("search\naddBook\nsetToRead\nrate\ngetBooks\nsuggestRead\naddBooks\nexit\n");

		String input = "null";
		Scanner scanner = new Scanner(System.in);

		// setup the input loop
		while (true) {
			System.out.print("Enter a command: ");
			input = scanner.nextLine();

			if (input.equals("exit")) {
				break;
			}

			// code for search
			if (input.equals("search")) {
				System.out.println("Do you want to search by title, author, or rating?");
				input = scanner.nextLine();

				if (input.equals("title")) {
					System.out.println("What is the title?");
					input = scanner.nextLine();
					library.booksByTitle(input).forEach((book) -> System.out.println(book));
				} else if (input.equals("author")) {
					System.out.println("What is the author?");
					input = scanner.nextLine();
					library.booksByAuthor(input).forEach((book) -> System.out.println(book));
				} else if (input.equals("rating")) {
					System.out.println("What is the rating?");
					input = scanner.nextLine();
					if (!input.equals("") && input.length() < 2 && Character.isDigit(input.charAt(0))
							&& Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 5) {
						library.booksByRating(Integer.parseInt(input)).forEach((book) -> System.out.println(book));
					} else {
						System.out.println("'" + input + "' not an integer between 1 and 5.");
					}
				} else {
					System.out.print("'" + input + "' not found as a command for search.");
				}
				// code for add book
			} else if (input.equals("addBook")) {
				String title;
				System.out.println("What is the title?");
				title = scanner.nextLine().trim();

				System.out.println("What is the author?");
				input = scanner.nextLine().trim();

				if (title == null || input == null) {
					System.out.println("One of the inputs was null. Try again.");
				} else if (title.equals("") || input.equals("")) {
					System.out.println("No input to one of the fields. Try again.");
				} else {
					library.addBook(title, input);
				}
				// code for set to read
			} else if (input.equals("setToRead")) {
				String title;
				System.out.println("What is the title of the book you read?");
				title = scanner.nextLine();

				System.out.println("Who is the author of the book you read?");
				input = scanner.nextLine();

				if (title == null || input == null) {
					System.out.println("One of the inputs was null. Try again.");
				} else if (title.equals("") || input.equals("")) {
					System.out.println("No input to one of the fields. Try again.");
				} else {
					ArrayList<Book> books = new ArrayList<Book>(library.booksByTitle(title));
					int index = 0;
					for (Book book : library.booksByAuthor(input)) {
						index = books.indexOf(book);
						if (index != -1) {
							library.setToRead(books.get(index));
							System.out.println(books.get(index) + " found and set to read if it wasn't already.");
						}
					}
				}
				// code for rate
			} else if (input.equals("rate")) {
				String title, rating;
				System.out.println("What is the title?");
				title = scanner.nextLine();

				System.out.println("Who is the author?");
				input = scanner.nextLine();

				System.out.println("What do you want to rate it?");

				rating = scanner.nextLine();

				if (title == null || input == null || rating == null) {
					System.out.println("One of the inputs was null. Try again.");
				} else if (title.equals("") || input.equals("") || rating.equals("")) {
					System.out.println("No input to one of the fields. Try again.");
				} else {
					if (rating.length() < 2 && Character.isDigit(rating.charAt(0)) && Integer.parseInt(rating) >= 1
							&& Integer.parseInt(rating) <= 5) {

						ArrayList<Book> books = new ArrayList<Book>(library.booksByTitle(title));
						int index = 0;
						for (Book book : library.booksByAuthor(input)) {
							index = books.indexOf(book);
							if (index != -1) {
								library.setRating(book, Integer.parseInt(rating));
								System.out.println(books.get(index) + " rated a " + rating + ".");
							}
						}

					} else {
						System.out.println("'" + rating + "' not an integer between 1 and 5. Try again.");
					}
				}
				// code for get books
			} else if (input.equals("getBooks")) {
				System.out.println("How would you like to sort the books?\nOptions: title, author, read, unread");
				input = scanner.nextLine();
				ArrayList<Book> books = new ArrayList<>();
				while (true) {
					if (input.equals("title")) {
						books = new ArrayList<>(library.sortedByTitle());
						System.out.println("Here are all books sorted by title:");
						break;
					} else if (input.equals("author")) {
						books = new ArrayList<>(library.sortedByAuthor());
						System.out.println("Here are all books sorted by author:");
						break;
					} else if (input.equals("read")) {
						books = new ArrayList<>(library.sortReadBooks());
						System.out.println("Here are all read books sorted by title:");
						break;
					} else if (input.equals("unread")) {
						books = new ArrayList<>(library.sortUnreadBooks());
						System.out.println("Here are all unread books sorted by title:");
						break;
					} else {
						System.out.println("Enter a valid input!\n");
					}
				}
				for (Book book : books) {
					System.out.println(book + "\n");
				}
				// code for suggest read
			} else if (input.equals("suggestRead")) {

				Book randomBook = library.suggestRead();
				if (randomBook == null) {
					System.out.println("No unread books found.");
				} else {
					System.out.println("you should read: \n" + randomBook + "\n");
				}
				// code for add books
			} else if (input.equals("addBooks")) {
				System.out.print("Enter filename: ");
				String filename = scanner.nextLine();
				library.addBooksFromFile(filename);
			} else {
				System.out.println("'" + input + "' not found as a command.");
			}
		}

		System.out.println("Library program over. Thank you for checking out our library.");
		scanner.close();
	}
}
