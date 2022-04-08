package com.hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book extends Item{

    @Id @GeneratedValue
    private String author;
    private String isbn;
}
