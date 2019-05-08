package service;

import domain.Book;

import java.util.ArrayList;
import java.util.List;


//TODO : 일단 뭐 할 지를 정해야지.
/* 1. Extract method : 를 만든다고 하면, 내부적으로 반복되는 동작. => library에 적용시키면? 대출인가. 대출 권수를 정하고, 그 만큼 반복하면서 책이 잇는지를 확인해야하므로
*  2. Decompose conditional : 내부적으로 조건이 긴것을 빼는것. => if에 조건이 여러개 걸린것, 즉 검색때, 책이름, 저자, 등등으로 검색하는 걸 하나로 표기하도록 변경.
* */
public class LibraryService {

    private List<Book> currentBookList;
    private List<Book> rentalBookList;

    public LibraryService(){
        this.currentBookList = new ArrayList<Book>();
        this.rentalBookList = new ArrayList<Book>();
    }

    // Book Searching method, Service methods call this method
    private int getIndexOfBook(List<Book> bookList, String name){
        for(int idx =0; idx<bookList.size();idx++){
            if(bookList.get(idx).getTitle().equals(name)){
                return idx;
            }
        }
        return -1;
    }

    // 조건을 이상하게 줄 것. TODO
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
    /* TODO 1. Extract method : 를 만든다고 하면, 내부적으로 반복되는 동작. => library에 적용시키면? 대출인가. 대출 권수를 정하고, 그 만큼 반복하면서 책이 잇는지를 확인해야하므로*/
    public void rentBooksToUser(String[] names){
        int rentBookQuantity = names.length;
        for(int i=0;i<rentBookQuantity;i++){
            for(int j=0;j<this.currentBookList.size();j++){
               if(currentBookList.get(j).equals(names[i])){
                   rentalBookList.add(currentBookList.get(j));
                   currentBookList.remove(j);
               }
            }
        }
    }

    // 2번째, if문에 조건을 이빠이 걸어주자.
    public Book searchWithDetailed(String title, String author, String publisher){
        for(int i=0;i<this.currentBookList.size();i++){
            Book tmpBook = currentBookList.get(i);
//            if(tmpBook.getTitle().equals(title)){
//                if(tmpBook.getAuthor().equals(author)){
//                    if(tmpBook.getPublisher().equals(publisher)){
//                        return tmpBook;
//                    }
//                }
//            }
            if(tmpBook.is(title, author, publisher)){
                return tmpBook;
            }
        }
        return null;
    }



//    public void rentOneBookToUser(String name){
//
//        int rentBookNumber = this.getIndexOfBook(currentBookList, name);
//        if (rentBookNumber == -1){
//            System.out.println("That book has benn rented");
//        }
//        else{
//            rentalBookList.add(currentBookList.get(rentBookNumber));
//            currentBookList.remove(rentBookNumber);
//        }
//    }

    // TODO : 3번째. Replace Temp Query 였나?
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

    public Book serchInCurrentList(String name){ // TODO : Replace Temp with Query
        int rentBookNumber = getIndexOfBook(currentBookList, name);
        if (rentBookNumber == -1){
            return null;
        }
        return currentBookList.get(getIndexOfBook(currentBookList,name));
    }

    public void addBookToList(Book book){
        currentBookList.add(book);
    }

    public void removeBookInList(String name){
        currentBookList.remove(getIndexOfBook(currentBookList,name));
    }

}
