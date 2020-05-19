package pl.prz.stud.clothesshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prz.stud.clothesshop.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
