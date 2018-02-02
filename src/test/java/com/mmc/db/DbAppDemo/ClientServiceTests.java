package com.mmc.db.DbAppDemo;

import com.mmc.db.DbAppDemo.model.Book;
import com.mmc.db.DbAppDemo.model.Client;
import com.mmc.db.DbAppDemo.services.ClientService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("file:src/main/resources/jdbc-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceTests {

    @Autowired
    ClientService clientService;

    @Test
    public void shouldReturnListOfClientsWhoOdrerBook(){
        Book book = new Book();
        book.setId(2);

        List<Client> expected = clientService.getClientsWhoOrderBook(book);

        Assertions.assertThat(expected).extracting("id").containsExactly(2L,3L,9L);
    }
}
