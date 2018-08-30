package com.egahi.ecommerce;

import java.util.*;

public class Storefront {
    protected LinkedList catalog = new LinkedList();

    public void addItem(String id, String name, String price,
        String quant) {
            Item it =  new Item(id, name, price, quant);
            catalog.add(it);
        }

        public Item getItem(int i) {
            return (Item) catalog.get(i);
        }

        public int getSize() {
            return catalog.size();
        }

        public void sort() {
            Collections.sort(catalog);
        }
}