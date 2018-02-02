package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Client;
import com.mmc.db.DbAppDemo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private JdbcTemplate jdbcTemplate;
    private OrderRowMapper orderRowMapper;

    @Autowired
    public OrderService(JdbcTemplate jdbcTemplate, OrderRowMapper orderRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.orderRowMapper = orderRowMapper;
    }

    public List<Order> fetchClientOrdersOrderByDateDesc(Client client){
        String query = String.format("SELECT * FROM zamowienia AS z, klienci WHERE z.idklienta = klienci.idklienta AND z.idklienta = %s ORDER BY data DESC",client.getId());
        List<Order> orders = jdbcTemplate.query(query, orderRowMapper);
        return orders;
    }
}
