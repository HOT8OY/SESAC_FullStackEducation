package com.ohgiraffers.mapping.section02.embedded;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookRegistService {

    private BookRepository bookRepository;

    // 생성자주입(autowired 생략 가능)
    public BookRegistService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void registBook(BookRegistDTO newBook) {

        Book book = new Book(
                newBook.getBookTitle(),
                newBook.getAuthor(),
                newBook.getPublisher(),
                newBook.getPublishedDate(),
                new Price(
                        newBook.getRegularPrice(),
                        newBook.getDiscountRate()
                )
        );
        bookRepository.save(book);
    }
}
