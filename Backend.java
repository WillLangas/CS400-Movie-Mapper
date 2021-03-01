import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

public class Backend implements BackendInterface {

  private List<MovieInterface> movieList = new LinkedList<MovieInterface>();
  private List<String> genres = new LinkedList<String>();
  private List<String> avgRatings = new LinkedList<String>();
  private List<String> containedGenres = new LinkedList<String>();
  private HashTableMap<String, GenreStorage> hashTable;

  public Backend(Reader input) throws FileNotFoundException, IOException, DataFormatException {
    MovieDataReaderInterface dataReader = new MovieDataReader();
    movieList = dataReader.readDataSet(input);
    for (int i = 0; i < movieList.size(); i++) {
      for (int j = 0; j < movieList.get(i).getGenres().size(); j++) {
        if (!containedGenres.contains(movieList.get(i).getGenres().get(j))) {
          containedGenres.add(movieList.get(i).getGenres().get(j));
        }
      }
    }
    hashTable = new HashTableMap<String, GenreStorage>(containedGenres.size());
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

  // public Backend(FileReader input) throws FileNotFoundException, IOException, DataFormatException
  // {
  // MovieDataReaderInterface dataReader;
  // movieList = dataReader.readDataSet(input);
  //
  // }

  @Override
  public void addGenre(String genre) {
    // TODO Auto-generated method stub
    if (!genres.contains(genre)) {
      genres.add(genre);
    }
    return;
  }

  @Override
  public void addAvgRating(String rating) {
    // TODO Auto-generated method stub
    if (avgRatings.contains(rating)) {
      return;
    }
    if (rating.equals("0") || rating.equals("1") || rating.equals("2") || rating.equals("3")
        || rating.equals("4") || rating.equals("5") || rating.equals("6") || rating.equals("7")
        || rating.equals("8") || rating.equals("9") || rating.equals("10")) {
      if (avgRatings.size() == 0) {
        avgRatings.add(rating);
      } else {
        for (int i = 0; i < avgRatings.size(); i++) {
          Integer value;
          Integer.parseInt(rating);
          if (Integer.parseInt(rating) > Integer.parseInt(avgRatings.get(i))) {
            avgRatings.add(i, rating);
            return;
          }
        }
        avgRatings.add(rating);
        return;
      }
    } else {
      throw new IllegalArgumentException();
    }
    return;
  }

  @Override
  public void removeGenre(String genre) {
    // TODO Auto-generated method stub
    if (!genres.contains(genre)) {
      throw new NoSuchElementException();
    }
    genres.remove(genre);
    return;
  }

  @Override
  public void removeAvgRating(String rating) {
    // TODO Auto-generated method stub
    if (!avgRatings.contains(rating)) {
      throw new NoSuchElementException();
    }
    avgRatings.remove(rating);
  }

  @Override
  public List<String> getGenres() {
    // TODO Auto-generated method stub
    return genres;
  }

  @Override
  public List<String> getAvgRatings() {
    // TODO Auto-generated method stub
    return avgRatings;
  }

  @Override
  public int getNumberOfMovies() {
    // TODO Auto-generated method stub
    List<MovieInterface> fullList = new LinkedList<MovieInterface>();
    List<MovieInterface> tempList = new LinkedList<MovieInterface>();
    for (int i = 0; i < genres.size(); i++) {
      try {
        tempList = hashTable.get(genres.get(i)).getMovies(avgRatings);
      for (int j = 0; j < tempList.size(); j++) {
        int rating = (int) tempList.get(j).getAvgVote().doubleValue();
        if (!fullList.contains(tempList.get(j))) {
          if (fullList.size() == 0) {
            fullList.add(tempList.get(j));
          } else {
            for (int k = 0; k < fullList.size(); k++) {
              if (tempList.get(j).compareTo(fullList.get(k)) >= 0) {
                fullList.add(k, tempList.get(j));
                break;
              }
            }
          }
        }
      }
      } catch (NoSuchElementException e) {}
    }
    return fullList.size();
  }

  @Override
  public List<String> getAllGenres() {
    // TODO Auto-generated method stub
    return containedGenres;
  }

  @Override
  public List<MovieInterface> getThreeMovies(int startingIndex) {
    // TODO Auto-generated method stub
    List<MovieInterface> fullList = new LinkedList<MovieInterface>();
    List<MovieInterface> tempList = new LinkedList<MovieInterface>();
    List<MovieInterface> output = new LinkedList<MovieInterface>();
    // Iterate through selected genres
    for (int i = 0; i < genres.size(); i++) {
      // Try statement to catch any genres that aren't present in the dataset
      try {
        // Get movies that have the specified average ratings
      tempList = hashTable.get(genres.get(i)).getMovies(avgRatings);
      for (int j = 0; j < tempList.size(); j++) {
        int rating = (int) tempList.get(j).getAvgVote().doubleValue();
        if (!fullList.contains(tempList.get(j))) {
          if (fullList.size() == 0) {
            fullList.add(tempList.get(j));
          } else {
            for (int k = 0; k < fullList.size(); k++) {
              if (tempList.get(j).compareTo(fullList.get(k)) >= 0) {
                fullList.add(k, tempList.get(j));
                break;
              }
              fullList.add(tempList.get(j));
            }
          }
        }
      }
      } catch (NoSuchElementException e) {}
    }
    for (int i = 0; i < 3; i++) {
      if (fullList.size() > i) {
        output.add(fullList.get(i + startingIndex));
      }
    }
    return output;
  }

}
