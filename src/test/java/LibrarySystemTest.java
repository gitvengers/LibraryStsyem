import domain.Book;
import service.LibraryService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class LibrarySystemTest {

    @Test // Test for addbook
    public void addBookTest(){
        Book lol = new Book("lol","me","riot",1);
        LibraryService service = mock(LibraryService.class);

        service.addBookToList(lol);
        System.out.println(service.serchInCurrentList("lol"));

        verify(service,times(1)).serchInCurrentList("lol");
    }

    @Test
    public void SearchBookTest(){
        Book lol = new Book("lol","me","riot",1);
        Book lol2 = new Book("lol2","me","riot",2 );

        LibraryService service = mock(LibraryService.class);

        service.addBookToList(lol);
        service.addBookToList(lol2);

        when(service.serchInCurrentList("lol")).thenReturn(lol);
        assertThat(service.serchInCurrentList("lol"),is(lol));
    }

    @Test
    public void RentBookTest(){
        Book lol = new Book("lol","me","riot",1);
        Book lol2 = new Book("lol2","me","riot",2 );

        LibraryService service = mock(LibraryService.class);

        service.addBookToList(lol);
        service.addBookToList(lol2);

        service.rentBookToUser("lol");

        when(service.serchInCurrentList("lol")).thenReturn(null);
        assertThat(service.serchInCurrentList("lol"),is(isNull()));
    }
    

    @Test
    public void returnToLibraryTest() {
        Book lol = new Book("lol","me","riot",1);

        LibraryService service = mock(LibraryService.class);

        service.addBookToList(lol);
        service.rentBookToUser("lol");
        service.returnToLibrary("lol");
        System.out.println(service.serchInCurrentList("lol"));

        verify(service,times(1)).serchInCurrentList("lol");
    }



}
