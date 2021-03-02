// --== CS400 File Header Information ==--
// Name: Joseph Peplinski
// Email: jnpeplinski@wisc.edu
// Team: Red
// Group: CC
// TA: Xi Chen
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.io.StringReader;
import java.util.NoSuchElementException;

/**
 * This class contains a set of tests for the back end of the Movie Mapper project.
 */
public class TestBackend {

  public static void main(String[] args) {
    (new TestBackend()).runTests();
  }

  public void runTests() {

    // Test method only affected by input data
    if (this.testGetAllGenres()) {
      System.out.println("Test get all genres: PASSED");
    } else {
      System.out.println("Test get all genres: FAILED");
    }

    // Test adding and removing genres
    System.out.print("Test add genre: ");
    if (this.testAddGenre()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test valid remove genre: ");
    if (this.testValidRemoveGenre()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test invalid remove genre: ");
    if (this.testInvalidRemoveGenre()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    // Test adding and removing ratings
    System.out.print("Test valid add rating: ");
    if (this.testValidAddRating()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test invalid add rating: ");
    if (this.testInvalidAddRating()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test valid remove rating: ");
    if (this.testValidRemoveRating()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test invalid remove rating: ");
    if (this.testInvalidRemoveRating()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    // Test movie count in various situations
    if (this.testInitialNumberOfMovies()) {
      System.out.println("Test initial number of movies: PASSED");
    } else {
      System.out.println("Test initial number of movies: FAILED");
    }

    System.out.print("Test number of movies with all ratings and empty genre: ");
    if (this.testGetNumberOfMoviesEmptyGenreAllRatings()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test number of movies with all ratings and a single genre: ");
    if (this.testGetNumberOfMoviesSingleGenreAllRatings()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test number of movies with all ratings and multiple genres: ");
    if (this.testGetNumberOfMoviesMultipleGenresAllRatings()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test number of movies with limited ratings and multiple genres: ");
    if (this.testGetNumberOfMoviesMultipleGenresLimitedRatings()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    // Test getting 3 movies in various situations
    if (this.testGetThreeMoviesInitial()) {
      System.out.println("Test get three movies sorted by rating (initial): PASSED");
    } else {
      System.out.println("Test get three movies sorted by rating (initial): FAILED");
    }

    System.out.print("Test get three movies sorted by rating (empty genre): ");
    if (this.testGetThreeMoviesEmptyGenre()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test get three movies sorted by rating (single movie returned): ");
    if (this.testGetThreeMoviesOneMovieReturned()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test get three movies sorted by rating (full list returned): ");
    if (this.testGetThreeMoviesFullListReturned()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

    System.out.print("Test get three movies sorted by rating (excess possible movies): ");
    if (this.testGetThreeMoviesThreeMoviesReturned()) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }

  }

  /**
   * This test instantiates the back end with three movies and tests whether the initial selection
   * is empty (getNumberOfMovies() returns 0). It passes when 0 is returned and fails in all other
   * cases, including when an exception is thrown.
   * 
   * @return true if the test passed, false if it failed
   */
  public boolean testInitialNumberOfMovies() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      if (backendToTest.getNumberOfMovies() == 0) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies and tests whether the getAllGenres method
   * return the correct set of genres for those three movies.
   * 
   * @return true if the test passed, false if it failed
   */
  public boolean testGetAllGenres() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      if (backendToTest.getAllGenres().size() == 5
          && backendToTest.getAllGenres().contains("Horror")
          && backendToTest.getAllGenres().contains("Action")
          && backendToTest.getAllGenres().contains("Comedy")
          && backendToTest.getAllGenres().contains("Musical")
          && backendToTest.getAllGenres().contains("Romance")) {
        // test passed
        return true;
      } else {
        // test failed
        for (int i = 0; i < backendToTest.getAllGenres().size(); i++) {
          System.out.println(backendToTest.getAllGenres().get(i));
        }
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies and tests whether the initial list
   * returned by getThreeMovies starting with the first movie (0) is empty. It passes when 0 is
   * returned and fails in all other cases, including when an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetThreeMoviesInitial() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      if (backendToTest.getThreeMovies(0).size() == 0) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies and tests whether adding genres results
   * in them being returned by getGenres(), passing if both of these genres are successfully added,
   * failing if they are not successfully added, and failing if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testAddGenre() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addGenre("Visual Tone Poem");
      backendToTest.addGenre("Documentary");
      if (backendToTest.getGenres().contains("Visual Tone Poem")
          && backendToTest.getGenres().contains("Documentary")) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies and tests whether adding valid ratings
   * results in them being added to getAvgRatings() correctly. If these ratings are successfully
   * added, the test passes, but if the ratings are not successfully added or an exception is
   * thrown, the test fails
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testValidAddRating() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("10");
      if (!backendToTest.getAvgRatings().contains("5")
          || !backendToTest.getAvgRatings().contains("3")
          || !backendToTest.getAvgRatings().contains("0")
          || !backendToTest.getAvgRatings().contains("10")) {
        // test failed
        return false;
      }
      return true;

    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies and tests whether adding invalid ratings
   * results in these ratings being rejected. This test passes if IllegalArgumentExceptions are
   * thrown in all situations and the invalid ratings are not added to getAvgRatings(), and fails if
   * the ratings are added or do not throw exceptions. This test also fails if unexpected exceptions
   * are thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testInvalidAddRating() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      // Only numbers should be allowed here
      try {
        backendToTest.addAvgRating("Text");
        if (backendToTest.getAvgRatings().contains("Text")) {
          return false;
        }
        return false;
      } catch (IllegalArgumentException e) {
        // test passed
      }
      // Only "0" through "10" should be allowed here, no decimals
      try {
        backendToTest.addAvgRating("3.1");
        if (backendToTest.getAvgRatings().contains("3.1")) {
          return false;
        }
        return false;
      } catch (IllegalArgumentException e) {
        // test passed
      }

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, and tests removing a genre after it have
   * been added. This test passes if the genre is no longer found within getGenres(), fails if it
   * is, and also fails if any exceptions are thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testValidRemoveGenre() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addGenre("Visual Tone Poem");
      backendToTest.removeGenre("Visual Tone Poem");
      if (backendToTest.getGenres().contains("Visual Tone Poem")) {
        // test failed
        return false;
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds a genre, and tests removing a genre
   * that has not been added. This test fails if a NoSuchElementException is not thrown by
   * removeGenre, if the added genre has been removed, if the genre which was removed has somehow
   * been added, or if an unexpected exception is thrown. Otherwise, it passes.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testInvalidRemoveGenre() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addGenre("Visual Tone Poem");
      try {
        backendToTest.removeGenre("Infrared Spectrum Tone Poem");
        return false;
      } catch (NoSuchElementException e) {
        // this is the expected behavior
      }

      if (!backendToTest.getGenres().contains("Visual Tone Poem")
          || backendToTest.getGenres().contains("Infrared Spectrum Tone Poem")) {
        // test failed
        return false;
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, and tests removing ratings after they
   * have been added. This test passes if the ratings are no longer found within getAvgRatings(),
   * fails if they are, and also fails if any exceptions are thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testValidRemoveRating() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));

      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.removeAvgRating("3");
      backendToTest.removeAvgRating("4");

      if (backendToTest.getAvgRatings().contains("4")
          || backendToTest.getAvgRatings().contains("3")) {
        return false;
      }
      return true;

    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds two valid average ratings, and then
   * attempts to remove an invalid rating and a rating which is not found within getAvgRatings().
   * Both of these are expected to throw NoSuchElementExceptions, and it is also expected that only
   * the two added average ratings are found within getAvgRatings(). If any of these conditions are
   * not satisfied, or if an unexpected exception is thrown, the test fails.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testInvalidRemoveRating() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));

      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      try {
        backendToTest.removeAvgRating("Text");
        return false;
      } catch (NoSuchElementException e) {
        // expected behavior
      }
      try {
        backendToTest.removeAvgRating("5");
        return false;
      } catch (NoSuchElementException e) {
        // expected behavior
      }

      if (backendToTest.getAvgRatings().size() == 2 && backendToTest.getAvgRatings().contains("4")
          && backendToTest.getAvgRatings().contains("3")) {
        return true;
      }
      return false;

    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds every possible average rating but
   * only one genre which does not exist within the movie database, and confirms that no movies are
   * found. This test passes if getNumberOfMovies() returns 0, and fails if this is not the case or
   * if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetNumberOfMoviesEmptyGenreAllRatings() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addGenre("Visual Tone Poem");
      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("1");
      backendToTest.addAvgRating("2");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("6");
      backendToTest.addAvgRating("7");
      backendToTest.addAvgRating("8");
      backendToTest.addAvgRating("9");
      backendToTest.addAvgRating("10");
      if (backendToTest.getNumberOfMovies() == 0) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds every possible average rating and
   * one genre present in the database, and confirms that one movie is found. This test passes if
   * getNumberOfMovies() returns 1, and fails if this is not the case or if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetNumberOfMoviesSingleGenreAllRatings() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addGenre("Horror");
      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("1");
      backendToTest.addAvgRating("2");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("6");
      backendToTest.addAvgRating("7");
      backendToTest.addAvgRating("8");
      backendToTest.addAvgRating("9");
      backendToTest.addAvgRating("10");
      if (backendToTest.getNumberOfMovies() == 1) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds every possible average rating and 3
   * genres present in the database (associated with 2 movies), and confirms that two movies are
   * found. This test passes if getNumberOfMovies() returns 2, and fails if this is not the case or
   * if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetNumberOfMoviesMultipleGenresAllRatings() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addGenre("Horror");
      backendToTest.addGenre("Comedy");
      backendToTest.addGenre("Musical");
      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("1");
      backendToTest.addAvgRating("2");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("6");
      backendToTest.addAvgRating("7");
      backendToTest.addAvgRating("8");
      backendToTest.addAvgRating("9");
      backendToTest.addAvgRating("10");
      if (backendToTest.getNumberOfMovies() != 2) {
        // test failed
        System.out.println(backendToTest.getNumberOfMovies());
        System.out.println(backendToTest.getThreeMovies(0).get(0));
        System.out.println(backendToTest.getAllGenres());
        return false;
      }
      // test passed
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds one average rating and 3 genres
   * present in the database (associated with 2 movies, though only one within the rating range),
   * and confirms that one movie is found. This test passes if getNumberOfMovies() returns 1, and
   * fails if this is not the case or if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetNumberOfMoviesMultipleGenresLimitedRatings() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addGenre("Horror");
      backendToTest.addGenre("Comedy");
      backendToTest.addGenre("Musical");
      backendToTest.addAvgRating("3");
      if (backendToTest.getNumberOfMovies() != 1) {
        // test failed
        return false;
      }
      // test passed
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds every possible average rating but
   * only one genre which does not exist within the movie database, and confirms that no movies are
   * found. This test passes if getThreeMovies(0) returns a list of size zero, and fails if this is
   * not the case or if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetThreeMoviesEmptyGenre() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("1");
      backendToTest.addAvgRating("2");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("6");
      backendToTest.addAvgRating("7");
      backendToTest.addAvgRating("8");
      backendToTest.addAvgRating("9");
      backendToTest.addAvgRating("10");
      backendToTest.addGenre("Visual Tone Poem");
      if (backendToTest.getThreeMovies(0).size() == 0) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds every possible average rating and
   * one genre found in the movie database, and confirms that one movie is found. This test passes
   * if getThreeMovies(0) returns a list of size 1 which has "The Source of Shadows" in it, and
   * fails if this is not the case or if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetThreeMoviesOneMovieReturned() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("1");
      backendToTest.addAvgRating("2");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("6");
      backendToTest.addAvgRating("7");
      backendToTest.addAvgRating("8");
      backendToTest.addAvgRating("9");
      backendToTest.addAvgRating("10");
      backendToTest.addGenre("Horror");
      if (backendToTest.getThreeMovies(0).size() == 1
          && backendToTest.getThreeMovies(0).get(0).getTitle().equals("The Source of Shadows")) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with three movies, adds every possible average rating and a
   * genre for each movie, and confirms that 3 movies are found, and that the last movie returned is
   * the lowest rated. This test passes if getThreeMovies(0) returns a list of size 3 with "The
   * Insurrection" at its tail, and fails if this is not the case or if an exception is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetThreeMoviesFullListReturned() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"));
      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("1");
      backendToTest.addAvgRating("2");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("6");
      backendToTest.addAvgRating("7");
      backendToTest.addAvgRating("8");
      backendToTest.addAvgRating("9");
      backendToTest.addAvgRating("10");
      backendToTest.addGenre("Horror");
      backendToTest.addGenre("Action");
      backendToTest.addGenre("Comedy");
      if (backendToTest.getThreeMovies(0).size() == 3
          && backendToTest.getThreeMovies(0).get(2).getTitle().equals("The Insurrection")) {
        // test passed
        return true;
      } else {
        // test failed
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }

  /**
   * This test instantiates the back end with four movies, adds every possible average rating and a
   * genre for each movie, and confirms that 3 (rather than 4) movies are found and that the first
   * movie returned is the highest rated. This test passes if getThreeMovies(0) returns a list of
   * size 3 with "Koyaanisqatsi" at its head, and fails if this is not the case or if an exception
   * is thrown.
   * 
   * @return true if the test passed, false if its failed
   */
  public boolean testGetThreeMoviesThreeMoviesReturned() {
    try {
      // instantiate once BackendInterface is implemented
      BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
              + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
              + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
              + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
              + "Koyaanisqatsi,Koyaanisqatsi,1982,\"Visual Tone Poem, Documentary\",86,USA,English,Godfrey Reggio,\"Ron Fricke, Michael Hoenig, Godfrey Reggio, Alton Walpole\",American Zoetrope,None,\"A collection of expertly photographed phenomena with no conventional plot. The footage focuses on nature, humanity and the relationship between them.\",8.3\n"));

      backendToTest.addAvgRating("0");
      backendToTest.addAvgRating("1");
      backendToTest.addAvgRating("2");
      backendToTest.addAvgRating("3");
      backendToTest.addAvgRating("4");
      backendToTest.addAvgRating("5");
      backendToTest.addAvgRating("6");
      backendToTest.addAvgRating("7");
      backendToTest.addAvgRating("8");
      backendToTest.addAvgRating("9");
      backendToTest.addAvgRating("10");
      backendToTest.addGenre("Horror");
      backendToTest.addGenre("Action");
      backendToTest.addGenre("Comedy");
      backendToTest.addGenre("Visual Tone Poem");
      if (backendToTest.getThreeMovies(0).size() == 3
          && backendToTest.getThreeMovies(0).get(0).getTitle().equals("Koyaanisqatsi")) {
        // test passed
        return true;
      } else {
        // test failed
        System.out.println(backendToTest.getThreeMovies(0).get(0).getTitle());
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      // test failed
      return false;
    }
  }
}
