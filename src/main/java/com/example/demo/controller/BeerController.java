package com.example.demo.controller;

import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/beer")
public class BeerController {
    private final BeerService beerService;
    @PostMapping()
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/beer/"+beer.getId().toString());
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping()
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }
    @GetMapping(value = "/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("Get Beer By Id - Controller");
        return beerService.getBerById(beerId);
    }
    @PutMapping("{beerId}")
    public ResponseEntity updateById(@RequestBody Beer beer, @PathVariable("beerId") UUID beerId){
        beerService.updateById(beerId, beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
