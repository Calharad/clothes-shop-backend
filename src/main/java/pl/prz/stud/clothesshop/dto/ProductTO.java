package pl.prz.stud.clothesshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductTO {
    private Long id;
    private String nazwa;
    private String opis;
    private List<ProductDetailTO> opisPunkty;
    private String cena;
    private List<String> rozmiary;
    private Boolean bestseller;
    private String obrazek;
    private Long kategoriaId;
    private Long podkategoriaId;
}
