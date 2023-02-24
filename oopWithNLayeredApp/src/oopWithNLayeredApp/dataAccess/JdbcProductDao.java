package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Product;

public class JdbcProductDao implements ProductDao {
    public void add(Product product){
        //Sadece db erişim kodlarını buraya yazıyoruz.
        System.out.println("Added to DB with Jdbc.");
    }
}
