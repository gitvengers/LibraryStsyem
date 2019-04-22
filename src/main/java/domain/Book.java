package domain;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int count;

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public void changePublisher(String newPublisher){
        this.publisher = newPublisher;
    }
}
