package com.gpcoder.patterns.structural.facade;

public class Client {
    public static void main(String[] args) {
        ShopFacade.getINSTANCE().buyProductByCashWithFreeShipping("phuongheh@gmail.com");
        ShopFacade.getINSTANCE().buyProductByPaypalWithStandardShipping("phuongheh@gmail.com", "0983.911.746");
    }
}
