package com.example.demo.mappers;

import com.example.demo.model.BeerDTO;
import com.example.demo.model.entities.Beer;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDTOToBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
