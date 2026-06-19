package book.book;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        BookDAO dao = new BookDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== BOOK MENU =====");
            System.out.println("1. Insert Book");
            System.out.println("2. Read All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter available copies: ");
                    int availableCopies = sc.nextInt();
                    dao.saveBook(new Book(title, author, category, price, availableCopies));
                    System.out.println("Book inserted successfully!");
                    break;

                case 2:
                    List<Book> books = dao.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter id of book to update: ");
                    int updateId = sc.nextInt();
                    Book existing = dao.getBook(updateId);
                    if (existing == null) {
                        System.out.println("Book not found.");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Enter new title: ");
                    existing.setTitle(sc.nextLine());
                    System.out.print("Enter new author: ");
                    existing.setAuthor(sc.nextLine());
                    System.out.print("Enter new category: ");
                    existing.setCategory(sc.nextLine());
                    System.out.print("Enter new price: ");
                    existing.setPrice(sc.nextDouble());
                    System.out.print("Enter new available copies: ");
                    existing.setAvailableCopies(sc.nextInt());
                    dao.updateBook(existing);
                    System.out.println("Book updated successfully!");
                    break;

                case 4:
                    System.out.print("Enter id of book to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteBook(deleteId);
                    System.out.println("Book deleted (if it existed).");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
