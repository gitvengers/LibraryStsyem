package repository;

import domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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

}
