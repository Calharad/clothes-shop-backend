package pl.prz.stud.clothesshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.prz.stud.clothesshop.model.ProductImage;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findAllByMainImageTrue();

    List<ProductImage> findAllByProduct_Id(Long product_id);

}
