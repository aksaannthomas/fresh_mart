package com.example.freshmart.Model;

public class Carts {
    private String Product_name,Product_price,Product_quanitiy;

    public Carts() {
    }

    public Carts(String product_name, String product_price, String product_quanitiy) {
        Product_name = product_name;
        Product_price = product_price;
        Product_quanitiy = product_quanitiy;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getProduct_price() {
        return Product_price;
    }

    public void setProduct_price(String product_price) {
        Product_price = product_price;
    }

    public String getProduct_quanitiy() {
        return Product_quanitiy;
    }

    public void setProduct_quanitiy(String product_quanitiy) {
        Product_quanitiy = product_quanitiy;
    }
}
