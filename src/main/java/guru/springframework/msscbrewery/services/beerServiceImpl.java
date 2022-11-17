package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class beerServiceImpl implements beerService{
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();

    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //yet to add real logic
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        //yet toa dd logic
    }
}
