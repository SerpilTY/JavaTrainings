package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class HybernateProductDao implements ProductDao{

    public void add(Product product) {
        System.out.println("Added to DB with Hybernate.");
    }
}
