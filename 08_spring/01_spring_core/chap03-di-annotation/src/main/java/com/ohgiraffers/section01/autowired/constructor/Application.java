package com.ohgiraffers.section01.autowired.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("constructorBookService",BookService.class); // 이름이 같으면(BookService) name을 따로 달아서 확실히 해준다.

        bookService.selectAllBooks().forEach(System.out::println);

        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));
    }
}
