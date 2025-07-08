package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the BookService bean and test DI
        BookService service = context.getBean("bookService", BookService.class);
        service.displayBook();  // This should print the book title injected via BookRepository

        ((ClassPathXmlApplicationContext) context).close();
    }
}
