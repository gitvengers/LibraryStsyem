package repository;

import domain.Book;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookRepoTest {

    @Mock
    private BookRepo bookRepo;

    @Test
    public void testFindByTitle() {
        //given
        given(bookRepo.findByTitle("리그오브레전드 가이드북")).willReturn(new Book("리그오브레전드 가이드북","Riot","Riot", 2));
        //when
        Book book =bookRepo.findByTitle("리그오브레전드 가이드북");
        //then
        verify(bookRepo, atLeast(1)).findByTitle("리그오브레전드 가이드북");
        assertThat(book.getTitle() ,is("리그오브레전드 가이드북"));
    }
    @Test
    public void testAddBookAtRepo(){
        Book book = mock(Book.class);
        bookRepo.addBook(book);
        verify(bookRepo, atLeast(1)).addBook(book);
    }

    @Test
    public void testFindAll(){
        given(bookRepo.findAll()).willReturn(new ArrayList<Book>());

        Book book = new Book();
        List<Book> books = bookRepo.findAll();
        bookRepo.addBook(book);

        assertThat(books.size(), is(1)); // mock객체라서 add가 안되용. 그래서 books.size()가 0 기대값은 1 test fail();
    }

    @Test(expected = MockitoException.class)
    public void testDoNoting(){
        doNothing().when(bookRepo).findByTitle(anyString());
        bookRepo.findByTitle("케넨이 감자를케넨");
        bookRepo.findByTitle("아리가 그걸 어찌아리");
        bookRepo.findByTitle("라이즈가 놀라면 서프라이즈");
    }
}
