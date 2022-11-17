package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface beerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeerById(UUID beerId);
}
