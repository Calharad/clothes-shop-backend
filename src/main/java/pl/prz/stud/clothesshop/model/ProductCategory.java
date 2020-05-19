package pl.prz.stud.clothesshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.type.TextType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "product_category")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ProductCategory {

    public ProductCategory(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<ProductSubcategory> subcategories;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
