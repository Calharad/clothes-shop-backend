package pl.prz.stud.clothesshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Product {

    public Product(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotNull
    private String description;

    @Column(nullable = false)
    @NotNull
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private ProductCategory category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private ProductSubcategory subcategory;

    private boolean isBestseller = false;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private Set<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private Set<ProductDetail> details;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private Set<ProductSize> sizes;
}
