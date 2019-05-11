package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private String title;
    private String author;
    private String publisher;
    private int count;

    public Book(){}

    public void changePublisher(String newPublisher){
        this.publisher = newPublisher;
    }
    public boolean isNull(){
        return false;
    }
}

