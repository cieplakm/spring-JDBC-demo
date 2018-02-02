package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> getBooksAlphabeticallyByTitle(){
        String query = "SELECT * FROM ksiazki ORDER BY tytul ASC";

        List<Book> books = jdbcTemplate.query(query, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setId(resultSet.getLong("idksiazki"));
                book.setAuthorsName(resultSet.getString("imieautora"));
                book.setAuthorsSurname(resultSet.getString("nazwiskoautora"));
                book.setTitle(resultSet.getString("tytul"));
                book.setPrice(resultSet.getShort("cena"));

                return book;
            }
        });

        return books;
    }
}
