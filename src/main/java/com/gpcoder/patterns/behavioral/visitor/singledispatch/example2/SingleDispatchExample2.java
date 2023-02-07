package com.gpcoder.patterns.behavioral.visitor.singledispatch.example2;

import com.gpcoder.patterns.behavioral.visitor.singledispatch.Book;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.ProgrammingBook;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.example1.Customer;

public class SingleDispatchExample2 {
    public static void main(String[] args) {
        Book book = new ProgrammingBook();
        Customer gpcoder = new Developer2();
        gpcoder.buy(book);

        ProgrammingBook programmingBook = new ProgrammingBook();
        gpcoder.buy(programmingBook);

    }
}
