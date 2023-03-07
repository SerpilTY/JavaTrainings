package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // Bu sınıf bir Business nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //iş kuralları
       List<Brand> brands=brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponses=brands.stream().
                map(brand->this.modelMapperService.forResponse().
                 map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponses;
    }

    @Override
    public GetByIdResponse GetById(int id) {
        Brand brand= brandRepository.findById(id).orElseThrow();
        GetByIdResponse response=this.modelMapperService.
                forResponse().map(brand, GetByIdResponse.class);
        return response;
    }

    @Override
    public void Add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
                Brand brand=modelMapperService.forRequest().
                map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void Update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=modelMapperService.forRequest().
                map(updateBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
