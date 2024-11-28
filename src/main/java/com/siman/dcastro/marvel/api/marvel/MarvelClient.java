package com.siman.dcastro.marvel.api.marvel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.siman.dcastro.marvel.models.entities.MarvelResponse;

@FeignClient(name = "marvelClient", url = "${MARVEL_API_URL}")
public interface MarvelClient {

    @GetMapping("/characters")
    MarvelResponse getCharacters(@RequestParam("ts") String timestamp,
            @RequestParam("apikey") String apiKey,
            @RequestParam("hash") String hash,
            @RequestParam("limit") int limit,
            @RequestParam("offset") int offset,
            @RequestParam(value = "nameStartsWith", required = false) String nameStartsWith);

    @GetMapping("/characters/{id}")
    MarvelResponse getCharactersId(@RequestParam("ts") String timestamp,
            @RequestParam("apikey") String apiKey,
            @RequestParam("hash") String hash,
            @PathVariable("id") String characterId);

}