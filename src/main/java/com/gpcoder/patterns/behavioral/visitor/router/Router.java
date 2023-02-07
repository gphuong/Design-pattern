package com.gpcoder.patterns.behavioral.visitor.router;

public interface Router {
    void sendData(char[] data);
    void acceptData(char[] data);
    void accept(RouterVisitor v);
}
