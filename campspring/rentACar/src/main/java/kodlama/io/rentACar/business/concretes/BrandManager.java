package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service // Bu sınıf bir Business nesnesidir.
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //iş kuralları
       List<Brand> brands=brandRepository.findAll();
       List<GetAllBrandsResponse> brandsResponses=new ArrayList<GetAllBrandsResponse>();

        for (Brand brand :brands
             ) {
            GetAllBrandsResponse myInstance=new GetAllBrandsResponse();
            myInstance.setId(brand.getId());
            myInstance.setName(brand.getName());
            brandsResponses.add(myInstance);
        }

        return brandsResponses;
    }

    @Override
    public void Add(CreateBrandRequest createBrandRequest) {
        Brand brand=new Brand();
        brand.setName(createBrandRequest.getName());

        this.brandRepository.save(brand);
    }
}
