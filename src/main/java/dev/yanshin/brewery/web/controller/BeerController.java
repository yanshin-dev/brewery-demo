package dev.yanshin.brewery.web.controller;

import dev.yanshin.brewery.services.BeerService;
import dev.yanshin.brewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/v1/beers")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity.ok(beerService.getBeer(beerId));
    }

    @PostMapping
    public ResponseEntity<BeerDto> createBeer(@RequestBody BeerDto beerDto) {
        var savedDto = beerService.createBeer(beerDto);
        //todo: replace hardcode URI
        var newResourceURI = URI.create("/api/v1/beers/" + savedDto.getId());
        return ResponseEntity.created(newResourceURI).body(savedDto);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}
