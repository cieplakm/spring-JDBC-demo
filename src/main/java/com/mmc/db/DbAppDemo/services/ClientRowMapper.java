package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Client;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getLong("idklienta"));
        client.setSurname(resultSet.getString("nazwisko"));
        client.setName(resultSet.getString("imie"));
        client.setCity(resultSet.getString("miejscowosc"));
        return client;
    }
}
