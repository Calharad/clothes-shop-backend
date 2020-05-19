package pl.prz.stud.clothesshop.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceConverter {
    public static String valueToPLN(BigDecimal value) {
        return Double.toString(value.setScale(2, RoundingMode.CEILING).doubleValue())
                .replace('.', ',')
                + " zł";
    }
}
