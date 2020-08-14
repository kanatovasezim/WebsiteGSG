package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.Package;
import kg.itacademy.gsg.exceptions.RecordNotFoundException;
import kg.itacademy.gsg.models.CategoryModel;
import kg.itacademy.gsg.models.PackageModel;
import kg.itacademy.gsg.repositories.PackageRepository;
import kg.itacademy.gsg.services.CategoryService;
import kg.itacademy.gsg.services.PackageService;
import kg.itacademy.gsg.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TaskService taskService;

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public List<PackageModel> getAll() {
        return packageRepository.getAll();
    }

    @Override
    public Page<PackageModel> findAll(Pageable pageable) {
        return packageRepository.findAllPackagesWithPagination(pageable);
    }


    @Override
    public Package getPackageById(Long id) {
        Optional<Package> p = packageRepository.findById(id);
        return p.orElse(new Package());
    }

    @Override
    public Page<CategoryModel> getAllCategoriesByPackageId(Long id, Pageable pageable) {
        return categoryService.getAllByPackageId(id, pageable);
    }

    @Override
    public Package updatePackage(PackageModel packageModel) {
        return packageRepository.findById(packageModel.getId())
                .map(newPackage -> {
                    newPackage.setTitle(packageModel.getTitle());
                    newPackage.setDescription(packageModel.getDescription());
                    newPackage.setPrice(packageModel.getPrice());
                    if(packageModel.getDiscountPrice() != null){
                        if (packageModel.getPrice().compareTo(packageModel.getDiscountPrice()) > 0)
                            newPackage.setDiscountPrice(packageModel.getDiscountPrice());
                    }else
                        newPackage.setDiscountPrice(null);
                    return packageRepository.save(newPackage);
                })
                .orElseThrow(() -> new RecordNotFoundException("Package not found with id:" + packageModel.getId()));
    }

    @Override
    public Package savePackage(PackageModel packageModel) {
        Package p = new Package();
        p.setTitle(packageModel.getTitle());
        p.setDescription(packageModel.getDescription());
        p.setPrice(packageModel.getPrice());
        p.setDiscountPrice(packageModel.getDiscountPrice());
        return savePackage(p);
    }

    @Override
    public Package savePackage(Package p) {
        return packageRepository.save(p);
    }

    @Override
    public void deletePackageById(Long id) {
        for (CategoryModel c : categoryService.getAllByPackageId(id)) {
            taskService.deleteTaskByCategoryId(c.getId());
            categoryService.deleteCategoryById(c.getId());
        }
        packageRepository.deleteById(id);
    }
}
