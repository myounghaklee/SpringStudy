package com.hellojpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Book extends Item{

    @Id @GeneratedValue
    private String author;
    private String isbn;
}
