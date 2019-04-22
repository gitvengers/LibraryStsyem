package domain;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String author;
    private String publisher;
    private int count;
}
