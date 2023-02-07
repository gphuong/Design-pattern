package com.gpcoder.patterns.behavioral.visitor.singledispatch.example1;

import com.gpcoder.patterns.behavioral.visitor.singledispatch.Book;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.ProgrammingBook;

public class SingleDispatchExample {
    public static void main(String[] args) {
        Book book = new ProgrammingBook();
        Customer gpCoder = new Developer();
        gpCoder.buy(book);

        ProgrammingBook programmingBook = new ProgrammingBook();
        gpCoder.buy(programmingBook);
    }
}
