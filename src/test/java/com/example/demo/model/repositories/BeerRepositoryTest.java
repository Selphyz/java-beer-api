package com.example.demo.model.repositories;

import com.example.demo.model.BeerStyle;
import com.example.demo.model.entities.Beer;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class BeerRepositoryTest {
    @Autowired
    BeerRepository beerRepository;

    @Test
    void testBerNameTooLong() {
        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("Test ajksdhkajshdqowiduqwoilkjsdklfjsdfiuoqwiueqwlkj8798ew7fsdhfsdoifyaqsa9087efwkjehflkwjeyhfw0e6")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("2344897934")
                    .price(new BigDecimal("11.99"))
                    .build());
            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("Test")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("2344897934")
                .price(new BigDecimal("11.99"))
                .build());
        beerRepository.flush();
        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}