package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.model.BeerStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBerById(UUID id) {
        return Beer.builder()
            .id(id)
            .version(1)
            .beerName("Galaxy Cat").beerStyle(BeerStyle.PALE_ALE)
            .upc("12343")
            .price(new BigDecimal("12.39"))
            .quantityOnHand(143)
            .createdDate(LocalDateTime.now())
            .updateDate(LocalDateTime.now())
            .build();
    }
}
