import implement.MovieServiceImplement;
import model.Movie;

public class Main {
    public static void main(String[] args){
        MovieServiceImplement movieService = new MovieServiceImplement();
        Movie movie1 = new Movie(1, "Final Destination");
        Movie movie2 = new Movie(2, "Final Source");
        Movie movie3 = new Movie(3, "Wolf of Wall Street");
        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);
        System.out.println(movieService.searchMovieByName("final"));
    }
}
