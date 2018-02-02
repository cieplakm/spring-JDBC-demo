package com.mmc.db.DbAppDemo.services;

import com.mmc.db.DbAppDemo.model.Order;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {

        Order order = new Order();
        order.setId(resultSet.getLong("idzamowienia"));
        order.setClientId(resultSet.getLong("idklienta"));
        order.setBookId(resultSet.getLong("idksiazki"));
        order.setData(resultSet.getLong("data"));
        order.setStatus(resultSet.getString("status"));

        return order;
    }
}
