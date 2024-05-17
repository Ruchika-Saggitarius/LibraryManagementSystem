package com.ruchika.lms.repositories;

import java.util.List;

import com.ruchika.lms.model.Book;

public interface IBookRepository {

    List<Book> getAllBooks();

    Book getBookByBookId(String bookId);

    void saveBook(Book newBook);

    void updateBookQuantityByBookId(String bookId, int newQuantity);

    void deleteBookByBookId(String bookId);

    boolean checkIfBookIdExists(String bookId);

    List<Book> getBooksByGenre(String genre);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByLanguage(String language);




    
}
