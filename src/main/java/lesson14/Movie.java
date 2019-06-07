package lesson14;

public class Movie implements Comparable {

    public String title;
    public int year;
    public double score;

    public Movie(String title, double score) {
        this.score = score;
        this.title = title;
    }

    public Movie(String title, double score, int year) {
        this.title = title;
        this.score = score;
        this.year = year;
    }

    @Override
    public int compareTo(Object o) {
        Movie m = (Movie)o;
        return (score < m.score) ? -1 : ((score == m.score) ? 0 : 1);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", score=" + score;
    }
}

