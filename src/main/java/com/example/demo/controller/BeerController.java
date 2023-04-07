package com.example.demo.controller;

import com.example.demo.model.Beer;
import com.example.demo.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;
    @RequestMapping("/beer")
    public List<Beer> listBeers(){
        return beerService.listBeers();
    }
    public Beer getBeerById(UUID id){
        log.debug("Get Beer By Id - Controller");
        return beerService.getBerById(id);
    }
}
