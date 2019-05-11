package service;

import domain.Book;
import domain.NullBook;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Book> currentBookList;
    private List<Book> rentalBookList;

    public LibraryService(){
        this.currentBookList = new ArrayList<Book>();
        this.rentalBookList = new ArrayList<Book>();
    }

    // Book Searching method, Service methods call this method
    private Book findBook(List<Book> bookList, String name){
        for(int idx =0; idx<bookList.size();idx++){
            if(bookList.get(idx).getTitle().equals(name)){
                return bookList.get(idx);
            }
        }
        return new NullBook();
    }

    public void rentBookToUser(String name){

        Book rentBook = this.findBook(currentBookList, name);
        if (rentBook.isNull()){
            System.out.println("That book has benn rented");
        }
        else{
            rentalBookList.add(rentBook);
            currentBookList.remove(rentBook);
        }
    }

    public void returnToLibrary(String name){
        Book returnBook = this.findBook(rentalBookList, name);
        if (returnBook.isNull()){
            System.out.println("That book is on Library");
        }
        else{
            currentBookList.add(returnBook);
            rentalBookList.remove(returnBook);
        }
    }

    public Book serchInCurrentList(String name){
        Book rentBook = this.findBook(currentBookList, name);
        if (rentBook.isNull()){
            return null;
        }
        return rentBook;
    }

    public void addBookToList(Book book){
        currentBookList.add(book);
    }

    public void removeBookInList(String name){
        currentBookList.remove(findBook(currentBookList,name));
    }
}
