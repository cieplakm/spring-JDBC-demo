package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        return bookFromResultSet(resultSet);
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
}
