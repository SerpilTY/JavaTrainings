package oopWithNLayeredApp;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {

        Product product=new Product(1,"IPhone Xr",9);
        ProductManager productManager=new ProductManager();
        productManager.add(product);
    }
}