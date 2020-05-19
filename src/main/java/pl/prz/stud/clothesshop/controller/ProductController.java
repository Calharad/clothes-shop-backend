package pl.prz.stud.clothesshop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.prz.stud.clothesshop.dto.CategoryTO;
import pl.prz.stud.clothesshop.dto.ProductImageTO;
import pl.prz.stud.clothesshop.dto.ProductTO;
import pl.prz.stud.clothesshop.dto.SubcategoryTO;
import pl.prz.stud.clothesshop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api("main products controller")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @ApiOperation(response = ProductTO.class, responseContainer = "List", value = "get products list")
    public List<ProductTO> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/product/{productId}/images")
    @ApiOperation(response = ProductImageTO.class, value = "get all images of product")
    public ProductImageTO getImagesForProduct(@PathVariable Long productId) {
        return productService.getImagesForProduct(productId);
    }

    @GetMapping("/categories")
    @ApiOperation(response = CategoryTO.class, responseContainer = "List", value = "get all categories")
    public List<CategoryTO> getCategories() {
        return productService.getCategories();
    }

    @GetMapping("/subcategories")
    @ApiOperation(response = SubcategoryTO.class, responseContainer = "List", value = "get all subcategories") public List<SubcategoryTO> getSubcategories() {
        return productService.getSubcategories();
    }

}
