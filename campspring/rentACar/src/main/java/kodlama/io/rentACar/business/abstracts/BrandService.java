package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

import java.util.List;


public interface BrandService {
List<GetAllBrandsResponse> getAll();
GetByIdResponse GetById(int id);
void Add (CreateBrandRequest createBrandRequest);
void Update(UpdateBrandRequest updateBrandRequest);
void delete(int id);

}
