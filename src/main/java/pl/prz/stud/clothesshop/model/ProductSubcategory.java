package pl.prz.stud.clothesshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "product_subcategory")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class ProductSubcategory {

    public ProductSubcategory(Long id) {
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ProductCategory category;

    @OneToMany(mappedBy = "subcategory")
    private Set<Product> products;
}
