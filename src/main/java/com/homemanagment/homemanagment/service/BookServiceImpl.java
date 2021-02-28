package com.homemanagment.homemanagment.service;

import com.homemanagment.homemanagment.model.Book;
import com.homemanagment.homemanagment.model.BookComparator;
import com.homemanagment.homemanagment.repositories.BookDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao repository;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Book> allBooks() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        this.repository.save(book);
    }

    @Override
    @Transactional
    public Book findBookByID(long id) {
        Optional<Book> book = repository.findById(id);
            return book.get();
    }

    @Override
    @Transactional
    public void removeBookById(long id, Book book) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public Book updateBookById(long id) {
        Optional<Book> book = repository.findById(id);
        return book.get();
    }

    public List<Book> search(String keyword){
        return repository.searchBookByTitle(keyword);
    }
}
