package dev.yanshin.brewery.services;

import dev.yanshin.brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeer(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name("Galaxy Cat")
                .style("Pale Ale")
                .build();
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name(beerDto.getName())
                .style(beerDto.getStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // todo: update beer
    }

    @Override
    public void deleteBeer(UUID beerId) {
        // todo: delete beer
    }
}
