package com.egahi.ecommerce;

public class Storefront2 extends Storefront {
    protected Boolean noDiscount = false;

    public void addItem(String id, String name, String price,
        String quant, Boolean noDiscount) {
            Item it =  new Item(id, name, price, quant, noDiscount);
            catalog.add(it);
        }
}