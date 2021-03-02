// --== CS400 File Header Information ==--
// Name: Joseph Peplinski
// Email: jnpeplinski@wisc.edu
// Team: Red
// Group: CC
// TA: Xi Chen
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

/**
 * A class to allow movies to be accessed through a hashtable
 * @author Joseph Peplinski
 *
 */
public class Backend implements BackendInterface {

  private List<MovieInterface> movieList = new LinkedList<MovieInterface>();
  private List<String> genres = new LinkedList<String>();
  private List<String> avgRatings = new LinkedList<String>();
  private List<String> containedGenres = new LinkedList<String>();
  private HashTableMap<String, GenreStorage> hashTable;

  /**
   * A constructor for the Backend which takes a Reader input, and generates the hashtable and
   * containedGenres list.
   * 
   * @param input a Reader containing the data format expected for MovieDataReader
   * @throws FileNotFoundException if there are issues with the input Reader
   * @throws IOException           if there are issues with the input Reader
   * @throws DataFormatException   if there are issues with the input Reader
   */
  public Backend(Reader input) throws FileNotFoundException, IOException, DataFormatException {
    // Set up the MovieDataReader
    MovieDataReaderInterface dataReader = new MovieDataReader();
    movieList = dataReader.readDataSet(input);
    // Go through the list of movies and add every unique genre found in the dataset
    for (int i = 0; i < movieList.size(); i++) {
      for (int j = 0; j < movieList.get(i).getGenres().size(); j++) {
        if (!containedGenres.contains(movieList.get(i).getGenres().get(j))) {
          containedGenres.add(movieList.get(i).getGenres().get(j));
        }
      }
    }
    // Create the hashtable to store these genres
    hashTable = new HashTableMap<String, GenreStorage>(containedGenres.size());
    // Fill up the hashtable with these genres and all of the movies with the specified genre
    for (int i = 0; i < containedGenres.size(); i++) {
      String currentGenre = containedGenres.get(i);
      GenreStorage genreDump = new GenreStorage(currentGenre);
      for (int j = 0; j < movieList.size(); j++) {
        if (movieList.get(j).getGenres().contains(containedGenres.get(i))) {
          genreDump.add(movieList.get(j));
        }
      }
      hashTable.put(containedGenres.get(i), genreDump);
    }
  }

  /**
   * A constructor for the Backend which takes a String array input containing the file path, and
   * generates the hashtable and containedGenres list.
   * 
   * @param args an array of strings with the first element containing a file path to the data set
   * @throws FileNotFoundException if there are issues with the input Reader
   * @throws IOException           if there are issues with the input Reader
   * @throws DataFormatException   if there are issues with the input Reader
   */
  public Backend(String[] args) throws FileNotFoundException, IOException, DataFormatException {
    // Throw an exception if the path is an empty string, that's clearly invalid
    if (args[0] == null) {
      throw new FileNotFoundException();
    }
    // Create a new FileReader from the input, and let it throw exceptions if this doesn't work
    FileReader input = new FileReader(args[0]);
    // Set up the MovieDataReader
    MovieDataReaderInterface dataReader = new MovieDataReader();
    movieList = dataReader.readDataSet(input);
    // Go through the list of movies and add every unique genre found in the dataset
    for (int i = 0; i < movieList.size(); i++) {
      for (int j = 0; j < movieList.get(i).getGenres().size(); j++) {
        if (!containedGenres.contains(movieList.get(i).getGenres().get(j))) {
          containedGenres.add(movieList.get(i).getGenres().get(j));
        }
      }
    }
    // Create the hashtable to store these genres
    hashTable = new HashTableMap<String, GenreStorage>(containedGenres.size());
    // Fill up the hashtable with these genres and all of the movies with the specified genre
    for (int i = 0; i < containedGenres.size(); i++) {
      String currentGenre = containedGenres.get(i);
      GenreStorage genreDump = new GenreStorage(currentGenre);
      for (int j = 0; j < movieList.size(); j++) {
        if (movieList.get(j).getGenres().contains(containedGenres.get(i))) {
          genreDump.add(movieList.get(j));
        }
      }
      hashTable.put(containedGenres.get(i), genreDump);
    }
  }

  /**
   * Adds a genre to the list of selected genres unless it is already in the list
   */
  @Override
  public void addGenre(String genre) {
    // No exceptions to throw here, since as long as the string is a string, it's a valid input
    // We'll just do nothing if the genre has already been added to the list
    if (!genres.contains(genre)) {
      genres.add(genre);
    }
    return;
  }

  /**
   * Adds an average rating to the list of selected average ratings unless it is already in the
   * list, or throws an IllegalArgumentException if the rating format is invalid
   */
  @Override
  public void addAvgRating(String rating) {
    // If the rating has already been added, don't do anything, but don't throw an exception
    if (avgRatings.contains(rating)) {
      return;
    }
    // Go into this region of code if the rating is one of the allowed ratings
    if (rating.equals("0") || rating.equals("1") || rating.equals("2") || rating.equals("3")
        || rating.equals("4") || rating.equals("5") || rating.equals("6") || rating.equals("7")
        || rating.equals("8") || rating.equals("9") || rating.equals("10")) {
      // If this rating is the first to be added, it doesn't matter where in the list it goes
      if (avgRatings.size() == 0) {
        avgRatings.add(rating);
      } else {
        // If it's not the first rating to be added to the list, it should be added in the correct
        // ascending order
        for (int i = 0; i < avgRatings.size(); i++) {
          if (Integer.parseInt(rating) > Integer.parseInt(avgRatings.get(i))) {
            avgRatings.add(i, rating);
            return;
          }
        }
        avgRatings.add(rating);
        return;
      }
    } else {
      // the input string does not match an expected input format, so we'll throw an exception
      throw new IllegalArgumentException();
    }
    return;
  }

  /**
   * Removes a genre, or throws a NoSuchElementException if the genre is not contained in the
   * selected genres list
   */
  @Override
  public void removeGenre(String genre) {
    // Throw an exception of there's no such genre to remove
    if (!genres.contains(genre)) {
      throw new NoSuchElementException();
    }
    genres.remove(genre);
    return;
  }

  /**
   * Removes an average rating, or throws a NoSuchElementException if the average rating is not
   * contained within the selected ratings list
   */
  @Override
  public void removeAvgRating(String rating) {
    // Throw an exception of there's no such rating to remove
    if (!avgRatings.contains(rating)) {
      throw new NoSuchElementException();
    }
    avgRatings.remove(rating);
  }

  /**
   * Returns a List<String> of all of the selected genres
   */
  @Override
  public List<String> getGenres() {
    return genres;
  }

  /**
   * Returns a List<String> of all of the selected average ratings
   */
  @Override
  public List<String> getAvgRatings() {
    return avgRatings;
  }


  private List<MovieInterface> getSelectedMovies() {
    // A private helper method to get all of the selected movies, in descending order of rating
    List<MovieInterface> fullList = new LinkedList<MovieInterface>();
    List<MovieInterface> tempList = new LinkedList<MovieInterface>();
    boolean added = false;
    // For each selected genre
    for (int i = 0; i < genres.size(); i++) {
      // Create a temporary list of all of the movies with the required ratings
      try {
        tempList = hashTable.get(genres.get(i)).getMovies(avgRatings);
        for (int j = 0; j < tempList.size(); j++) {
          added = false;
          // If the final list doesn't have the movie, add it in the correct position
          if (!fullList.contains(tempList.get(j))) {
            if (fullList.size() == 0) {
              fullList.add(tempList.get(j));
              added = true;
            } else {
              // Iterate through the final list and add the movie ahead of the existing movie if it
              // is ranked higher
              for (int k = 0; k < fullList.size(); k++) {
                if (tempList.get(j).compareTo(fullList.get(k)) >= 0) {
                  fullList.add(k, tempList.get(j));
                  added = true;
                  break;
                }

              }
              // If the movie hasn't been added at this point, but the final list doesn't have it,
              // add it to the end, as it is lower ranked than everything else
              if (!added) {
                fullList.add(tempList.get(j));
              }
            }
          }
        }
      } catch (NoSuchElementException e) {
      }
    }
    return fullList;
  }

  /**
   * Returns the number of movies currently selected
   */
  @Override
  public int getNumberOfMovies() {
    return getSelectedMovies().size();
  }

  /**
   * Returns a list of all of the genres found within the dataset
   */
  @Override
  public List<String> getAllGenres() {
    return containedGenres;
  }

  /**
   * Returns a List<MovieInterface> of three movies in descending rating order, starting at an index
   * offset from the highest rated movie currently selected
   */
  @Override
  public List<MovieInterface> getThreeMovies(int startingIndex) {
    // Get all of the movies (in descending ranking order) that have the selected attributes
    List<MovieInterface> list = getSelectedMovies();
    List<MovieInterface> output = new LinkedList<MovieInterface>();
    // Create a list of up to 3 movies, starting at a certain position in the list
    for (int i = 0; i < 3; i++) {
      // Only try to add a movie if it's within the bounds of the list
      if (i + startingIndex < list.size()) {
        output.add(list.get(i + startingIndex));
      }
    }
    return output;
  }

}
