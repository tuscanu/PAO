package implement;

import model.Movie;
import service.MovieService;

public class MovieServiceImplement implements MovieService {

    Movie[] movies;
    int nrMovies;
    public MovieServiceImplement(){
        movies=new Movie[100];
        nrMovies=0;
    }
    @Override
    public Movie[] searchMovieByName(String Name) {
        Movie[] moviesSearch=new Movie[100];
        int length=0;
        for(Movie movie : movies){
            if(movie == null)
                break;
            String movieName=movie.getName().toLowerCase();
            if(movieName.contains(Name.toLowerCase())) {
                moviesSearch[length++] = movie;
            }
    if(moviesSearch.length==0)
        System.out.println("Nu exista filme cu numele respectiv!");
    else
        System.out.println("Exista filme cu numele respectiv!");

        }
        return moviesSearch;
    }


    @Override
    public void addMovie(Movie movie) {
        movies[nrMovies++] = movie;
        System.out.println("Adaugarea a fost facuta cu succes");
    }

    @Override
    public void deleteMovie(String Name) {
        boolean found = false;
        for (int i = 0; i < nrMovies; i++) {
            if (movies[i].getName().equalsIgnoreCase(Name)) {
                for (int j = i; j < nrMovies - 1; j++) {
                    movies[j] = movies[j + 1];
                }
                movies[nrMovies - 1] = null;
                nrMovies--;
                found = true;
                System.out.println("Filmul '" + Name + "' a fost șters cu succes!");
                break;
            }
        }
        if (!found) {
            System.out.println("Nu s-a găsit niciun film cu numele '" + Name + "' pentru ștergere!");
        }
    }
}
