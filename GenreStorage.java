import java.util.LinkedList;
import java.util.List;

public class GenreStorage {
  private String genre = null;
  private LinkedList<MovieInterface>[] movieArray;

  public GenreStorage(String genre) {
    this.genre = genre;
    movieArray = (LinkedList<MovieInterface>[]) new LinkedList[11];

    for (int i = 0; i < movieArray.length; i++) {
      movieArray[i] = new LinkedList<MovieInterface>();
    }
  }

  public boolean add(MovieInterface movie) {

    if (!movie.getGenres().contains(genre)) {
      return false;
    }
    
    int rating = (int) movie.getAvgVote().doubleValue();
    movieArray[rating].add(movie);
//    if (!movieArray[rating].contains(movie)) {
//      if (movieArray[rating].size() == 0) {
//        movieArray[rating].add(movie);
//      } else {
//        for (int i = 0; i < movieArray[rating].size(); i++) {
//          if (movie.compareTo(movieArray[rating].get(i)) >= 0) {
//            movieArray[rating].add(i, movie);
//            break;
//          }
//        }
//      }
//  }
    return true;
  }
  public List<MovieInterface> getBest(List<String> ratings, int offset) {
    List<MovieInterface> output = new LinkedList<MovieInterface>();
    int numMovies = 0;
    for (int i = 0; i < ratings.size(); i++) {
      for (int j = 0; j < movieArray[Integer.parseInt(ratings.get(i))].size(); j++) {
        output.add(movieArray[Integer.parseInt(ratings.get(i))].get(j));
        numMovies++;
        if (numMovies == 3 + offset) {
          return output;
        }
      }
    }
    return output;
  }
  
  public List<MovieInterface> getMovies(List<String> ratings) {
    List<MovieInterface> output = new LinkedList<MovieInterface>();
    for (int i = 0; i < ratings.size(); i++) {
      for (int j = 0; j < movieArray[Integer.parseInt(ratings.get(i))].size(); j++) {
        output.add(movieArray[Integer.parseInt(ratings.get(i))].get(j));
      }
    }
    return output;
  }
}
