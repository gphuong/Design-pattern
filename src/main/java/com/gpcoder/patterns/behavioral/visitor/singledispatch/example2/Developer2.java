package com.gpcoder.patterns.behavioral.visitor.singledispatch.example2;

import com.gpcoder.patterns.behavioral.visitor.singledispatch.Book;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.BusinessBook;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.ProgrammingBook;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.example1.Customer;

public class Developer2 implements Customer {
    @Override
    public void buy(Book book) {
        if (book instanceof ProgrammingBook) {
            ProgrammingBook programmingBook = (ProgrammingBook) book;
            buy(programmingBook);
        } else if (book instanceof BusinessBook) {
            BusinessBook businessBook = (BusinessBook) book;
            buy(businessBook);
        } else {
            System.out.println("Developer buy a Book");
        }
    }

    @Override
    public void buy(ProgrammingBook book) {
        System.out.println("Developer buy a Programming Book");
    }

    @Override
    public void buy(BusinessBook book) {
        System.out.println("Developer buy a Business Book");
    }
}
