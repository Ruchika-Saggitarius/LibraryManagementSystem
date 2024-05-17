package com.ruchika.lms.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ruchika.lms.model.Book;

public class MockBookRepository implements IBookRepository {

    List<Book> books = new ArrayList<Book>();

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookByBookId(String bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookByBookId'");
    }

    @Override
    public void saveBook(Book newBook) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveBook'");
    }

    @Override
    public void updateBookQuantityByBookId(String bookId, int newQuantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBookQuantityByBookId'");
    }

    @Override
    public void deleteBookByBookId(String bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBookByBookId'");
    }

    @Override
    public boolean checkIfBookIdExists(String bookId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkIfBookIdExists'");
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooksByGenre'");
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooksByAuthor'");
    }

    @Override
    public List<Book> getBooksByLanguage(String language) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooksByLanguage'");
    }
    
}
