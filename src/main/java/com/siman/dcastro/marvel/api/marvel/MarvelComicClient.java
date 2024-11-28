package com.siman.dcastro.marvel.api.marvel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.siman.dcastro.marvel.models.entities.ComicResponse;


@FeignClient(name = "marvelComicClient", url = "${MARVEL_API_URL}")
public interface MarvelComicClient {

    @GetMapping("/characters/{id}/comics")
    ComicResponse getComicsCharactersId(@RequestParam("ts") String timestamp,
            @RequestParam("apikey") String apiKey,
            @RequestParam("hash") String hash,
            @PathVariable("id") String characterId);

    @GetMapping("/comics/{id}")
    ComicResponse getComicsById(@RequestParam("ts") String timestamp,
                    @RequestParam("apikey") String apiKey,
                    @RequestParam("hash") String hash,
                    @PathVariable("id") String comicId);

}
