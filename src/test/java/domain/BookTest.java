package domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BookTest {
    @Test
    public void testChangeBookPublisher(){
        Book book = new Book();

        book.setTitle("리그오브레전드 가이드북");
        book.setAuthor("RiotGames");
        book.setPublisher("Ten cent");

        book.changePublisher("Steam");
        assertThat(book.getPublisher(), is("Steam"));
    }
}