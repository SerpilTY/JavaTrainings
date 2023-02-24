package oopWithNLayeredApp;

import oopWithNLayeredApp.business.ProductManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Logger> loggers= new ArrayList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());
        Product product=new Product(1,"IPhone Xr",10000);
        ProductManager productManager=new ProductManager(new JdbcProductDao(),loggers);
        productManager.add(product);


    }
}