package lesson14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("A", 4.4));
        movies.add(new Movie("AB", 2.6));
        movies.add(new Movie("AC", 5.7));
        movies.add(new Movie("AD", 7.3));
        movies.add(new Movie("AE", 10.0));
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        System.out.println("Sorting");
        Collections.sort(movies);
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        //po title
        Collections.sort(movies, new MovieTitlesComparator());
        System.out.println(movies);

        //ocenke
        Collections.sort(movies, new MovieScoreComparator());
        System.out.println(movies);
    }
}
