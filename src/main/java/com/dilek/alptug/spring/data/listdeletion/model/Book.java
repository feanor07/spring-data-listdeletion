package com.dilek.alptug.spring.data.listdeletion.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="book")
@Data
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String name;
    private int publishYear;
    @Version
    private int version;
}
