// --== CS400 File Header Information ==--
// Name: Joseph Peplinski
// Email: jnpeplinski@wisc.edu
// Team: Red
// Group: CC
// TA: Xi Chen
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.ArrayList;
import java.util.List;

/**
 * A class designed to contain movie genres and associated movies, and provide convenient access to
 * certain information about the movies within an instance of the class
 * 
 * @author Joseph Peplinski
 *
 */
public class GenreStorage {
  // The genre that is contained within this instance
  private String genre = null;
  // An array to contain movies with certain average ratings, truncated to integers which correspond
  // to indexes 0 through 10 of the array
  private ArrayList<MovieInterface>[] movieArray = (ArrayList<MovieInterface>[]) new ArrayList[11];

  /**
   * A constructor for this class, creating an instance containing movies of the input genre
   * 
   * @param genre the genre of movies to be contained within this instance of GenreStorage
   */
  public GenreStorage(String genre) {
    this.genre = genre;

    // Initialize every element of the movieArray, or else we'll end up with errors
    for (int i = 0; i < movieArray.length; i++) {
      movieArray[i] = new ArrayList<MovieInterface>();
    }
  }

  /**
   * Adds a movie to this class
   * 
   * @param movie the MovieInterface object to be stored in this instance of GenreStorage
   * @return true if added, false if not added
   */
  public boolean add(MovieInterface movie) {

    // If the movie isn't of this genre, don't add it
    if (!movie.getGenres().contains(genre)) {
      return false;
    }

    int rating = (int) movie.getAvgVote().doubleValue();
    // If the movie is already in the array, don't add it again
    if (movieArray[rating].contains(movie)) {
      return false;
    }
    // Add the movie to the array at the correct index
    movieArray[rating].add(movie);
    return true;
  }

  /**
   * Returns all of the movies with the specified ratings
   * 
   * @param ratings a list of the (integer-formatted string) ratings specified
   * @return a list of all movies contained within this class with the specified ratings
   */
  public List<MovieInterface> getMovies(List<String> ratings) {
    List<MovieInterface> output = new ArrayList<MovieInterface>();
    // Go through each rating within the input ratings
    for (int i = 0; i < ratings.size(); i++) {
      // Add all of the movies with this rating to the output list
      for (int j = 0; j < movieArray[Integer.parseInt(ratings.get(i))].size(); j++) {
        output.add(movieArray[Integer.parseInt(ratings.get(i))].get(j));
      }
    }
    return output;
  }
}
