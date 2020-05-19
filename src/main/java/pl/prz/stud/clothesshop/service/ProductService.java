package pl.prz.stud.clothesshop.service;

import org.springframework.stereotype.Service;
import pl.prz.stud.clothesshop.converter.PriceConverter;
import pl.prz.stud.clothesshop.dto.*;
import pl.prz.stud.clothesshop.model.Product;
import pl.prz.stud.clothesshop.model.ProductImage;
import pl.prz.stud.clothesshop.model.ProductSize;
import pl.prz.stud.clothesshop.repositories.ProductCategoryRepository;
import pl.prz.stud.clothesshop.repositories.ProductImageRepository;
import pl.prz.stud.clothesshop.repositories.ProductRepository;
import pl.prz.stud.clothesshop.repositories.ProductSubcategoryRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductRepository productRepository;

    private final ProductSubcategoryRepository productSubcategoryRepository;

    private final ProductImageRepository productImageRepository;

    public ProductService(ProductCategoryRepository productCategoryRepository, ProductRepository productRepository, ProductSubcategoryRepository productSubcategoryRepository, ProductImageRepository productImageRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
        this.productSubcategoryRepository = productSubcategoryRepository;
        this.productImageRepository = productImageRepository;
    }

    public List<ProductTO> getProducts() {
        List<Product> products = productRepository.findAll();
        Map<Long, String> productMainImages = productImageRepository.findAllByMainImageTrue()
                .stream().collect(Collectors.toMap(pi -> pi.getProduct().getId(), ProductImage::getSrc));
        return products.stream().map(p ->
                ProductTO.builder()
                    .bestseller(p.isBestseller())
                    .cena(PriceConverter.valueToPLN(p.getPrice()))
                    .kategoriaId(p.getCategory().getId())
                    .podkategoriaId(p.getSubcategory().getId())
                    .nazwa(p.getName())
                    .opis(p.getDescription())
                    .obrazek(productMainImages.get(p.getId()))
                    .opisPunkty(p.getDetails().stream().map(pd -> new ProductDetailTO(pd.getValue())).collect(Collectors.toList()))
                    .rozmiary(p.getSizes().stream().map(ProductSize::getSize).collect(Collectors.toList()))
                    .build()
                )
                .collect(Collectors.toList());
    }

    public List<CategoryTO> getCategories() {
        return productCategoryRepository.findAll()
                .stream().map(c -> new CategoryTO(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    public List<SubcategoryTO> getSubcategories() {
        return productSubcategoryRepository.findAll()
                .stream().map(c -> SubcategoryTO.builder()
                        .id(c.getId())
                        .kategoriaId(c.getCategory().getId())
                        .nazwa(c.getName())
                        .build()
                )
                .collect(Collectors.toList());
    }

    public ProductImageTO getImagesForProduct(Long productId) {
        List<ProductImage> images = productImageRepository.findAllByProduct_Id(productId);
        ProductImageTO result = new ProductImageTO();
        result.setId(productId);
        result.setObrazki(images.stream().map(i -> new ImageTO(i.getSrc())).collect(Collectors.toList()));
        return result;
    }

}
