package dev.yanshin.brewery.web.model;

import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {
    private UUID uuid;
    private String beerName;
    private String beerStyle;
    private Long upc;
}
