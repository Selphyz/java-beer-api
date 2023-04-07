package com.example.demo.service;

import com.example.demo.model.Beer;
import com.example.demo.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    private Map<UUID, Beer> beerMap;
    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();
        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat").beerStyle(BeerStyle.PALE_ALE)
                .upc("12343")
                .price(new BigDecimal("12.39"))
                .quantityOnHand(143)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank").beerStyle(BeerStyle.PALE_ALE)
                .upc("12343")
                .price(new BigDecimal("16.79"))
                .quantityOnHand(423)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Angel Shot").beerStyle(BeerStyle.PALE_ALE)
                .upc("12343")
                .price(new BigDecimal("18.39"))
                .quantityOnHand(765)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }
    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }
    @Override
    public Beer getBerById(UUID id) {
        log.debug("Get Beer Id called");
        return beerMap.get(id);
    }
}
