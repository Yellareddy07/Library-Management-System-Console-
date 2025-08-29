package BOOK;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private int year;

    public boolean isborrowed;
    private String borrowedby;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isborrowed=false;
        this.borrowedby=null;

    }

    public void borrowBook(String borrower){
        isborrowed=true;
        borrowedby=borrower;
    }

    public void returnBook(){
        isborrowed=false;
        borrowedby=null;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public boolean isIsborrowed() {
        return isborrowed;
    }

    public String getBorrowedby() {
        return borrowedby;
    }

    @Override
    public String toString() {
        String status=isborrowed?" Borrowed by "+borrowedby:" Available";
        return "Book{" +
                "Id=" + id +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Year=" + year +
                '}' + status;
    }


    public int getyear() {
        return year;
    }

    public boolean isborrowed() {
        return isborrowed;
    }
}
