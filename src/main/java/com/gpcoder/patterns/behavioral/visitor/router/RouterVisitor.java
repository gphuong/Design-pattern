package com.gpcoder.patterns.behavioral.visitor.router;

public interface RouterVisitor {
    void visit(DLinkRouter router);

    void visit(TPLinkRouter router);

    void visit(LinkSysRouter router);
}
