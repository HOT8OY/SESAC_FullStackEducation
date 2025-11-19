package com.ohgiraffers.section01.autowired.setter;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("setterBookService")
public class BookService {

    /* [ Setter 주입 ] */

    private BookDAO bookDAO;

    // bookDAO 타입의 bean 객체를 setter에 자동 주입(setter 주입)
    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }

}
