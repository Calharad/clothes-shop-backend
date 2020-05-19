package pl.prz.stud.clothesshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageTO {
    private Long id;
    private List<ImageTO> obrazki;
}
