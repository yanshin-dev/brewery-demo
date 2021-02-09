package dev.yanshin.brewery.services;

import dev.yanshin.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
