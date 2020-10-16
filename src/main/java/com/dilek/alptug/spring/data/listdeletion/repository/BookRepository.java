package com.dilek.alptug.spring.data.listdeletion.repository;

import com.dilek.alptug.spring.data.listdeletion.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { }

