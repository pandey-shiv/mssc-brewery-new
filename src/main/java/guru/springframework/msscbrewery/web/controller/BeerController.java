package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.beerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final beerService beerservice;

    public BeerController(beerService beerservice) {
        this.beerservice = beerservice;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerservice.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto){
        BeerDto saveDto = beerservice.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer"+saveDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable UUID beerId,@RequestBody BeerDto beerDto){
        beerservice.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId ){
        beerservice.deleteBeerById(beerId);
    }
}
