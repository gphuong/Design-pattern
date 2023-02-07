package com.gpcoder.patterns.behavioral.visitor.singledispatch.example1;

import com.gpcoder.patterns.behavioral.visitor.singledispatch.Book;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.BusinessBook;
import com.gpcoder.patterns.behavioral.visitor.singledispatch.ProgrammingBook;

public interface Customer {
    void buy(Book book);

    void buy(ProgrammingBook book);

    void buy(BusinessBook book);

}
