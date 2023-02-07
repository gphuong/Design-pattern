package com.gpcoder.patterns.behavioral.visitor.router;

public class VisitorPatternExample {
    private static MacConfigurator macConfigurator;
    private static LinuxConfigurator linuxConfigurator;

    public static void main(String[] args) {
        macConfigurator = new MacConfigurator();
        linuxConfigurator = new LinuxConfigurator();
        testDlink();
        testTPLink();
        testLinkSys();
    }

    private static void testLinkSys() {
        LinkSysRouter linksys = new LinkSysRouter();
        linksys.accept(macConfigurator);
        linksys.accept(linuxConfigurator);
    }

    private static void testTPLink() {
        TPLinkRouter tplink = new TPLinkRouter();
        tplink.accept(macConfigurator);
        tplink.accept(linuxConfigurator);
    }

    private static void testDlink() {
        DLinkRouter dlink = new DLinkRouter();
        dlink.accept(macConfigurator);
        dlink.accept(linuxConfigurator);
    }

}
