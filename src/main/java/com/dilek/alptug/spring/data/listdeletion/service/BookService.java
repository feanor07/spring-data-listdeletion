package com.dilek.alptug.spring.data.listdeletion.service;

import com.dilek.alptug.spring.data.listdeletion.model.Book;
import com.dilek.alptug.spring.data.listdeletion.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void populateDBWithPredefinedBooks() {
        List<Book> books = new ArrayList<>();
        books.add(newBook("Aylak Adam", "Yusuf Atilgan", 1959));
        books.add(newBook("Tutunamayanlar", "Oguz Atay", 1972));
        books.add(newBook("Puslu Kitalar Atlasi", "Ihsan Oktay Anar", 1995));
        books.add(newBook("Kara Kitap", "Orhan Pamuk", 1994));
        books.add(newBook("Yaban", "Yakup Kadri Karaosmanoglu", 1932));
        books.add(newBook("Kurtlar Kanunu", "Kemal Tahir", 1972));
        books.add(newBook("Gun Olur Asra Bedel", "Cengiz Aytmatov", 1981));

        bookRepository.saveAll(books);
    }

    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }
    
    public void deleteAllBooksViaIteration() {
        for (Book book : bookRepository.findAll()) {
            bookRepository.delete(book);
        }
    }

    public void deleteAllBooksAsList() {
        bookRepository.deleteAll(bookRepository.findAll());
    }

    private Book newBook(String name, String author, int publishYear) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPublishYear(publishYear);

        return book;
    }
}
