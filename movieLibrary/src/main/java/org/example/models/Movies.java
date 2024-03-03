package org.example.models;

import java.util.List;

public class Movies {

    private String title;

    //agregacja
    private Director director;
    private List<Actor> actors;

    public Movies(String title, Director director, List<Actor> actors) {
        this.title = title;
        this.director = director;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "title='" + title + '\'' +
                ", director=" + director +
                ", actors=" + actors +
                '}';
    }
}
