package org.example.models;


import org.example.handlers.RandomDataProvider;
import org.example.handlers.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieLibrary {

    private static List<Movies> movies ;

    public static List<Movies> getMovies() {

        return movies;
    }
    public static void setMovies(List<Movies> movies) {
        MovieLibrary.movies = movies;
    }

    public void fillMoviesList(){

        movies = new ArrayList<>();
        Director ridleyScott = new Director("Ridley", "Scott");
        Director g_Verbinski = new Director("Gore","Verbinski");
        Director q_Tarantino = new Director("Quentin","Tarantino");
        Director p_Jackson = new Director("Peter","Jackson");

        Actor russelCRow = new Actor("Russel", "Crow");
        Actor o_Reed = new Actor("Oliver", "Reed");
        Actor d_Jacob = new Actor("Derek", "Jacob");
        Actor j_Deep = new Actor("Johnny", "Deep");
        Actor o_Bloom = new Actor("Orlando", "Bloom");
        Actor k_Knightley = new Actor("Keira", "Knightley");
        Actor j_Travolta = new Actor("John", "Travolta");
        Actor u_Thurman = new Actor("Uma", "Thurman");
        Actor h_Keitel = new Actor("Harvey", "Keitel");
        Actor t_Cruze = new Actor("Tom", "Cruise");

        movies.add(new Movies("Gladiator", ridleyScott, List.of(russelCRow,k_Knightley,j_Travolta)));
        movies.add(new Movies("Pirates of the Caribbean",g_Verbinski, List.of(o_Reed, j_Deep)));
        movies.add(new Movies("Pulp Fiction",q_Tarantino, List.of(j_Travolta, u_Thurman)));
        movies.add(new Movies("Hobbit - An Unexpected Jorney",p_Jackson, List.of(k_Knightley, d_Jacob)));
        movies.add(new Movies("Poranek Kojota",p_Jackson, List.of(russelCRow, o_Bloom)));
        movies.add(new Movies("Transformers",q_Tarantino, List.of(russelCRow, d_Jacob)));
        movies.add(new Movies("Top Gun",p_Jackson, List.of(russelCRow, t_Cruze)));
        movies.add(new Movies("Desperado",p_Jackson, List.of(russelCRow, o_Bloom)));
        movies.add(new Movies("Mission Impossible",p_Jackson, List.of(russelCRow, t_Cruze)));
        movies.add(new Movies("Forest Gump",g_Verbinski, List.of(o_Reed, h_Keitel)));

    }

    public void getRandomMovieInformation() {
        System.out.println(movies.get(RandomDataProvider.getRandomIndex()));
    }

    public void getFilmsForActor() {
        Actor actor = UserInput.getActorFromUser();
        List<String> actorFilmographyList = getActorFilmographyList(actor);
        if (actorFilmographyList.isEmpty()) {
            System.out.println(actor + " didn't play in any movie from library.");
        } else {
            System.out.println("Actor " + actor + " have played in movies:");
            String separator = "";

            for (String movie : actorFilmographyList) {
                System.out.print(separator + movie);
                separator = ", ";
            }
        }
    }
    private List<String> getActorFilmographyList(Actor actorToFind) {
        Predicate<Movies> movieCheck = movie -> movie.getActors().stream()
                .anyMatch(actor -> actor.getFirstName().equals(actorToFind.getFirstName()) &&
                        actor.getLastName().equals(actorToFind.getLastName()));

        return movies.stream()
                .filter(movieCheck)
                .map(Movies::getTitle)
                .collect(Collectors.toList());
    }

}
