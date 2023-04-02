package com.example.demo.service;

import com.example.demo.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBerById(UUID id);
}
