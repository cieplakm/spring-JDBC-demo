package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Book;
import com.mmc.db.DbAppDemo.model.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Client> clientRowMapper;

    public ClientService(JdbcTemplate jdbcTemplate, RowMapper<Client> clientRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.clientRowMapper = clientRowMapper;
    }

    public List<Client> getClientsWhoOrderBook(Book book){
        String query = String.format("SELECT * FROM klienci, zamowienia WHERE klienci.idklienta = zamowienia.idklienta AND zamowienia.idksiazki = %s", book.getId());
        List<Client> clients = jdbcTemplate.query(query, clientRowMapper);
        return clients;
    }


}
