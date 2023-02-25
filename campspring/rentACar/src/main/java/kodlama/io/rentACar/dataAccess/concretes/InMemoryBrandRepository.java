package kodlama.io.rentACar.dataAccess.concretes;

import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Bu sınıf bir DataAccess nesnesidir.
public class InMemoryBrandRepository implements BrandRepository {
    List<Brand> brands;

    public InMemoryBrandRepository() {
        brands=new ArrayList<Brand>();
        brands.add(new Brand(1,"Peugout"));
        brands.add(new Brand(2,"Volvo"));
        brands.add(new Brand(3,"Mercedes"));
        brands.add(new Brand(4,"Opel"));
        brands.add(new Brand(5,"Audi"));
        brands.add(new Brand(6,"Mini Cooper"));
    }

    public List<Brand> getAll() {
        return brands;
    }
}
