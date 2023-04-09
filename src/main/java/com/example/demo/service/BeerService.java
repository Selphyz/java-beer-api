package com.example.demo.service;

import com.example.demo.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateById(UUID beerId, Beer beer);
}
