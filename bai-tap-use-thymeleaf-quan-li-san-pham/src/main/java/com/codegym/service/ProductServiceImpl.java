package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService{

    private static final Map<Integer, Product> products;

    static {
    products = new HashMap<>();
    products.put(1,new Product(1,"Car",10000,"Toy","USA"));
    products.put(2,new Product(2,"Naruto",4000,"Manga","Japan"));
    products.put(3,new Product(3,"Coca-Cola",8000,"Drink","USA"));
    products.put(4,new Product(4,"Iphone",15000,"Mobile Phone","USA"));
    products.put(5,new Product(5,"Seiko",11000,"Watch","USA"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id ,product);
    }


    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public Product findByID(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products1 = new ArrayList<>();
        for (int p: products.keySet()
             ) {
            Product product = products.get(p);
            if (product.getName().contains(name)){
                products1.add(product);
            }
        }
        return products1;
    }
}
