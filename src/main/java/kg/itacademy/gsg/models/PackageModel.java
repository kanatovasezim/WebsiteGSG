package kg.itacademy.gsg.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PackageModel {

    Long id;
    String title;
    String description;
    BigDecimal price;
    BigDecimal discountPrice;

}
