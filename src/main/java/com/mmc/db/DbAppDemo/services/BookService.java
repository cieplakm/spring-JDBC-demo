package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Book;
import com.mmc.db.DbAppDemo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Book> bookRowMapper;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate, RowMapper<Book> bookRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.bookRowMapper = bookRowMapper;
    }

    public List<Book> getBooksAlphabeticallyByTitle(){
        String query = "SELECT * FROM ksiazki ORDER BY tytul ASC";
        return jdbcTemplate.query(query, bookRowMapper);
    }

    public Book getTheMostExpensiveBook(){
        String query = "SELECT * FROM ksiazki ORDER BY cena DESC LIMIT 1";
        return jdbcTemplate.queryForObject(query, bookRowMapper);
    }


    public List<Book> getBooksOrderedBy(Client client){
        String query = String.format("SELECT * FROM ksiazki AS k, zamowienia AS z WHERE z.idksiazki = k.idksiazki AND z.idklienta = %s", client.getId()) ;
        return jdbcTemplate.query(query, bookRowMapper);
    }

    


}
