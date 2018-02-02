package com.mmc.db.DbAppDemo;

import com.mmc.db.DbAppDemo.model.Client;
import com.mmc.db.DbAppDemo.model.Order;
import com.mmc.db.DbAppDemo.services.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/jdbc-config.xml")
public class OrderServiceTests {

    @Autowired
    OrderService orderService;

    @Test
    public void shouldFetchAllOrdersOdreredByClientAndSortedByDateDesc(){
        Client client = new Client();
        client.setId(9);

        List<Order> expected = orderService.fetchClientOrdersOrderByDateDesc(client);

        Assertions.assertThat(expected).extracting("id").containsSequence(10L, 3L);

    }
}
