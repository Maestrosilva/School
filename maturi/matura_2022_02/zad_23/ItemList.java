package matura_2022_02.zad_23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemList {
    private final List<Item> products = new ArrayList<>();

    public List<Item> getProducts() {
        return products;
    }

    public int size() {
        return products.size();
    }

    public Item get(int index) {
        try {
            return products.get(index);
        }
        catch (IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Invalid index");
        }
    }

    public void add(Item item) {
        if (products.contains(item)) {
            throw new IllegalStateException("Product already exists!");
        }
        products.add(item);
        Collections.sort(products);
    }
}
