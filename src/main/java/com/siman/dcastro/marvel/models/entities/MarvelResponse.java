package com.siman.dcastro.marvel.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private List<Character> results;

        public List<Character> getResults() {
            return results;
        }

        public void setResults(List<Character> results) {
            this.results = results;
        }
    }

    public static class Comic{

        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }


    }

    public static class Serie{

        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }


    }

    public static class Item{
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Character {
        private String name;
        private String description;

        private Comic comics;
        private Serie series;


        public Comic getComics() {
            return comics;
        }

        public void setComics(Comic comics) {
            this.comics = comics;
        }

        public Serie getSeries() {
            return series;
        }

        public void setSeries(Serie series) {
            this.series = series;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

}
