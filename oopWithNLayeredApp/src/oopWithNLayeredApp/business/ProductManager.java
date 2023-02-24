package oopWithNLayeredApp.business;

import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.dataAccess.ProductDao;
import oopWithNLayeredApp.entities.Product;

public class ProductManager {

    private ProductDao productDao;

    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void add(Product product) throws Exception {
        //sadece  iş kuralları
        if (product.getUnitPrice()<10){
            throw new Exception("Price can not be less than 10");
        }
        //ProductDao productDao=new JdbcProductDao();
        //
        //Bir katman başka bir katmanın classını kullanıyorken sadece
        //interface'inden erişim kurmalıdır.
        // Entity'ler dışında. O yüzden 20. satırı kaldırmam gerekiyor.
        //Bunun yerine interface injection yapıyorum.
        //9-12 satırlar bağımlılık yönetimi ve son satırda bunu kullandık.

        productDao.add(product);
    }
}
