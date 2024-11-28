package com.siman.dcastro.marvel.services.marvel;

import org.springframework.stereotype.Service;

import com.siman.dcastro.marvel.api.marvel.MarvelClient;
import com.siman.dcastro.marvel.api.marvel.MarvelComicClient;
import com.siman.dcastro.marvel.models.entities.ComicResponse;
import com.siman.dcastro.marvel.models.entities.MarvelResponse;

@Service
public class MarvelService {

    private final MarvelClient marvelClient;
    private final MarvelComicClient marvelComicClient;
    private final MarvelAuthService authService;

    public MarvelService(MarvelClient marvelClient,MarvelComicClient marvelComicClient, MarvelAuthService authService) {
        this.marvelClient = marvelClient;
        this.authService = authService;
        this.marvelComicClient=marvelComicClient;
    }

    public MarvelResponse getCharacters(int limit, int offset,String name) {
        MarvelAuthService.MarvelAuth auth = authService.generateAuth();

        return marvelClient.getCharacters(auth.timestamp(), auth.apiKey(), auth.hash(), limit, offset, (name.trim().equals("") ? null:name));

    }

    public MarvelResponse getCharactersId(String characterId) {
        MarvelAuthService.MarvelAuth auth = authService.generateAuth();

        return marvelClient.getCharactersId(auth.timestamp(), auth.apiKey(), auth.hash(),characterId);

    }

    public ComicResponse getComicsCharactersId(String characterId) {
        MarvelAuthService.MarvelAuth auth = authService.generateAuth();

        return marvelComicClient.getComicsCharactersId(auth.timestamp(), auth.apiKey(), auth.hash(),characterId);

    }


    public ComicResponse getComicsById(String comicId) {
        MarvelAuthService.MarvelAuth auth = authService.generateAuth();

        return marvelComicClient.getComicsById(auth.timestamp(), auth.apiKey(), auth.hash(),comicId);

    }


}
