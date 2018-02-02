package com.mmc.db.DbAppDemo.model;

import lombok.Data;

@Data
public class Book {
    long id;
    String authorsName;
    String authorsSurname;
    String title;
    float price;
}
