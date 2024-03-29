package lesson14;

import java.util.Comparator;

public class MoviesYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o1.year, o2.year);
    }
}
