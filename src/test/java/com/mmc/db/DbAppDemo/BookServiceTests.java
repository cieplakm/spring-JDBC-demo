package com.mmc.db.DbAppDemo;

import com.mmc.db.DbAppDemo.model.Book;
import com.mmc.db.DbAppDemo.model.Client;
import com.mmc.db.DbAppDemo.services.BookService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/resources/jdbc-config.xml")
public class BookServiceTests {

    @Autowired
    BookService bookService;

    @Test
    public void shouldReturnListOfBooksOrderedByNameAsc(){
        List<Book> booksOrderefByAc = bookService.getBooksAlphabeticallyByTitle();

        Assertions.assertThat(booksOrderefByAc).isNotEmpty();
        Assertions.assertThat(booksOrderefByAc.get(0).getTitle()).isEqualTo("HTML5. Tworzenie witryn");
        Assertions.assertThat(booksOrderefByAc.get(booksOrderefByAc.size()-1).getTitle()).isEqualTo("Zaawansowane programowanie w PHP");

    }

    @Test
    public void shouldReturnTheMostExpensiveBook(){
        Book theMostExpensiveBook = bookService.getTheMostExpensiveBook();
        float mostExpensiveBookPrice = 53.65F;

        Assertions.assertThat(theMostExpensiveBook).isNotNull();
        Assertions.assertThat(theMostExpensiveBook.getPrice()).isEqualTo(mostExpensiveBookPrice);
    }

    @Test
    public void shouldReturnAllBooksOrderedByClient(){
        Client client = new Client();
        client.setId(2);

        List<Book> expected = bookService.getBooksOrderedBy(client);

        Assertions.assertThat(expected).isNotNull();
        Assertions.assertThat(expected).extracting("id").containsExactly(4L,2L,5L);
    }


}
