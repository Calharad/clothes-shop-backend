package pl.prz.stud.clothesshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class SubcategoryTO {
    private Long id;
    private String nazwa;
    private Long kategoriaId;
}
