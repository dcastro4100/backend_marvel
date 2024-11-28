package com.siman.dcastro.marvel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siman.dcastro.marvel.models.entities.ComicResponse;
import com.siman.dcastro.marvel.models.entities.MarvelResponse;
import com.siman.dcastro.marvel.services.marvel.MarvelService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/marvel")
public class MarvelController {

    private final MarvelService marvelService;

    public MarvelController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }


    @GetMapping("/characters")
    public MarvelResponse getCharacters(
        @RequestParam(defaultValue = "10") int limit,
        @RequestParam(defaultValue = "0") int offset,
        @RequestParam(defaultValue = "") String name
        ) {
        return marvelService.getCharacters(limit, offset,name);
    }

    @GetMapping("/characters/{id}")
    public MarvelResponse getCharactersId(
        @PathVariable("id") String id
        ) {
        return marvelService.getCharactersId(id);
    }

    @GetMapping("/characters/{id}/comics")
    public ComicResponse getComicsCharactersId(
        @PathVariable("id") String id
        ) {
        return marvelService.getComicsCharactersId(id);
    }
    
}
