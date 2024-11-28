package com.siman.dcastro.marvel.models.entities;

import java.util.List;


public class ComicResponse {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private List<Comic> results;

        public List<Comic> getResults() {
            return results;
        }

        public void setResults(List<Comic> results) {
            this.results = results;
        }
    }

    public static class Comic {
        private String title;
       
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

}
