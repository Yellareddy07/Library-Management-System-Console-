import BOOK.Book;
import LIBRARY.Library;

import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Library lib=new Library();
        lib.loadFromFile();

        Scanner sc=new Scanner(System.in);

        while (true){
            System.out.println("Library Menu");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");
            int choice=sc.nextInt();
            sc.nextLine();


            switch (choice){
                case 1: {
                    System.out.println("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.println("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.println("Enter Year: ");
                    int year = sc.nextInt();

                    lib.addBook(new Book(id,title,author,year));
                    break;
                }
                case 2: {
                    lib.viewBooks();
                    break;
                }

                case 3: {
                    System.out.println("Enter Keyword: ");
                    String keyword = sc.nextLine();
                    lib.searchBook(keyword);
                    break;
                }

                case 4: {
                    int id1 = -1;
                    while (true) {
                        try {
                            System.out.print("Enter ID to delete: ");
                            id1 = sc.nextInt();   // throws exception if not a number
                            sc.nextLine(); // consume newline
                            break; // exit loop if valid
                        } catch (Exception e) {
                            System.out.println("Invalid input! Please enter a number.");
                            sc.nextLine(); // clear the invalid input
                        }
                    }
                    lib.deleteBook(id1);
                    break;
                }

                case 5:
                {
                    System.out.println("Enter Book ID to borrow: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your name: ");
                    String name=sc.nextLine();
                    lib.borrowBook(id,name);
                    break;
                }
                case 6:
                {
                    System.out.println("Enter Book ID to return: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    lib.returnBook(id);
                    break;
                }
                case 7: {
                    System.out.println("Exiting....");
                    sc.close();
                    return;
                }

                default: {
                    System.out.println("Invalid Choice");
                    break;
                }
            }

        }
    }
}