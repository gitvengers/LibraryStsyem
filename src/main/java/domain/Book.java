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

    public boolean is(String title, String author, String publisher) {
        if (this.getTitle().equals(title)) {
            if (this.getAuthor().equals(author)) {
                return this.getPublisher().equals(publisher);
            }
        }
        return false;
    }
}

