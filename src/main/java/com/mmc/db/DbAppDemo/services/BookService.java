package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<Book> bookRowMapper = new BookRowMapper();


    public List<Book> getBooksAlphabeticallyByTitle(){
        String query = "SELECT * FROM ksiazki ORDER BY tytul ASC";

        List<Book> books = jdbcTemplate.query(query, bookRowMapper);

        return books;
    }

    public Book getTheMostExpensiveBook(){
        String query = "SELECT * FROM ksiazki ORDER BY cena DESC LIMIT 1";
        Book book = jdbcTemplate.queryForObject(query, bookRowMapper);
        return book;
    }

    private Book bookFromResultSet(ResultSet resultSet) throws SQLException{
        Book book = new Book();
        book.setId(resultSet.getLong("idksiazki"));
        book.setAuthorsName(resultSet.getString("imieautora"));
        book.setAuthorsSurname(resultSet.getString("nazwiskoautora"));
        book.setTitle(resultSet.getString("tytul"));
        book.setPrice(resultSet.getFloat("cena"));
        return book;
    }


    private class BookRowMapper implements RowMapper<Book>{
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            return bookFromResultSet(resultSet);
        }
    }

}
