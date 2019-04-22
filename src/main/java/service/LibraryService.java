package service;

import domain.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Book> currentBookList = new ArrayList<Book>();
    private List<Book> rentalBookList = new ArrayList<Book>();

    // Book Searching method, Service methods call this method
    private int getIndexOfBook(List<Book> bookList, String name){
        for(int idx =0; idx<bookList.size();idx++){
            if(bookList.get(idx).getTitle() == name){
                return idx;
            }
        }
        return -1;
    }

    public void rentBookToUser(String name){

        int rentBookNumber = this.getIndexOfBook(currentBookList, name);
        if (rentBookNumber == -1){
            System.out.println("That book has benn rented");
        }
        else{
            rentalBookList.add(currentBookList.get(rentBookNumber));
            currentBookList.remove(rentBookNumber);
        }
    }

    public void returnToLibrary(String name){
        int returnBookNumber = this.getIndexOfBook(rentalBookList, name);
        if (returnBookNumber == -1){
            System.out.println("That book is on Library");
        }
        else{
            currentBookList.add(rentalBookList.get(returnBookNumber));
            rentalBookList.remove(returnBookNumber);
        }
    }

    public Book serchInCurrentList(String name){
        return currentBookList.get(getIndexOfBook(currentBookList,name));
    }

    public void addBookToList(Book book){
        this.currentBookList.add(book);
    }

    public void removeBookInList(String name){
        this.currentBookList.remove(getIndexOfBook(currentBookList,name));
    }
}
