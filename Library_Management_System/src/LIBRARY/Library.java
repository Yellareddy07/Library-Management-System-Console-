package LIBRARY;
import BOOK.Book;
import java.io.*;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();
/*
    private final String FILE_NAME="books.txt";*/
    private final String FILE_NAME="books3.txt";


    public void addBook(Book book) throws FileNotFoundException {
        books.add(book);
        saveToFile();
        System.out.println("Book added successfully!");
    }

    public void viewBooks(){
        if(books.isEmpty()){
            System.out.println("No books Available");
        }
        else {
            books.forEach(System.out::println);
        }
    }

    public void searchBook(String keyword){
        boolean found=false;
        for(Book b:books){
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase())||
            b.getAuthor().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(b);
                found=true;
            }
        }
        if (!found){
            System.out.println("Book not Found");
        }
    }

    public void deleteBook(int id) throws Exception {
        books.removeIf(b->b.getId()==id);
        saveToFile();
    }


    public void borrowBook(int id,String borrower) throws FileNotFoundException {
        for (Book b:books){
            if(b.getId()==id){
                if(b.isborrowed){
                    System.out.println("Sorry, This Book is Already Borrowed");
                }
                else {
                    b.borrowBook(borrower);
                    System.out.println("Book Borrowed Successfully");
                    saveToFile();
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }


    public void returnBook(int id) throws FileNotFoundException {
        for (Book b:books){
            if(b.getId()==id) {
                if (!b.isborrowed) {
                    System.out.println("This book is not Borrowed");
                } else {
                    b.returnBook();
                    System.out.println("Book returned Successfully");
                    saveToFile();
                }
                return;
            }}
        System.out.println("Book not found!");
    }
/*
    public void saveToFile() throws FileNotFoundException {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving file:"+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void loadFromFile(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FILE_NAME))){
           books=(ArrayList<Book>) ois.readObject();
        }
        catch (Exception e){
            books=new ArrayList<>();
        }
    }
*/
    // ✅ Save books in CSV format
    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                pw.println(b.getId() + "," + b.getTitle() + "," + b.getAuthor() + "," +
                        b.getyear() + "," + b.isborrowed() + "," +
                        b.getBorrowedby());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // ✅ Load books from CSV
    public void loadFromFile() {
        books = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                int year = Integer.parseInt(data[3]);
                boolean borrowed = Boolean.parseBoolean(data[4]);
                String borrower = data.length > 5 ? data[5] : "";

                Book b = new Book(id, title, author, year);
                if (borrowed) {
                    b.borrowBook(borrower); // ✅ restore state
                }
                books.add(b);

            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

}}
