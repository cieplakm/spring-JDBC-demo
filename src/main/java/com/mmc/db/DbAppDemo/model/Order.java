package com.mmc.db.DbAppDemo.model;

import lombok.Data;

@Data
public class Order {
    long id;
    long clientId;
    long bookId;
    long data;
    String status;

}
