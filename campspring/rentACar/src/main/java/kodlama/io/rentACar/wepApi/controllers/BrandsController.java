package kodlama.io.rentACar.wepApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdResponse getById(@PathVariable int id){
        return brandService.GetById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void Add(CreateBrandRequest createBrandRequest){  this.brandService.Add(createBrandRequest);}

    @PutMapping
    public void Update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.Update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable int id ){
        this.brandService.delete(id);

    }
}
