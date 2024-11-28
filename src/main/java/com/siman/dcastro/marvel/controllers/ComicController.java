package com.siman.dcastro.marvel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siman.dcastro.marvel.models.entities.ComicResponse;
import com.siman.dcastro.marvel.services.marvel.MarvelService;


@RestController
@RequestMapping("/comic")
public class ComicController {


     private final MarvelService marvelService;

    public ComicController(MarvelService marvelService) {
        this.marvelService = marvelService;
    }

    @GetMapping("/{id}")
    public ComicResponse getComicById(
            @PathVariable("id") String id) {
        return marvelService.getComicsById(id);
    }

}
