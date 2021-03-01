import java.io.StringReader;
import java.util.NoSuchElementException;

/**
 * This class contains a set of tests for the back end of the Movie Mapper
 * project.
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
     * This test instantiates the back end with three movies and tests whether the
     * initial selection is empty (getNumberOfMovies() returns 0). It passes when 0
     * is returned and fails in all other cases, including when an exception is
     * thrown.
     * 
     * @return true if the test passed, false if it failed
     */
    public boolean testInitialNumberOfMovies() {
	try {
	    // instantiate once BackendInterface is implemented
	    BackendInterface backendToTest = new Backend(new StringReader(
						    "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
						    +
						    "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
						    +
						    "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
						    +
						    "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
						    ));
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
     * This test instantiates the back end with three movies and tests whether the
     * getAllGenres method return the correct set of genres for those three movies.
     * 
     * @return true if the test passed, false if it failed
     */
    public boolean testGetAllGenres() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
	    if (backendToTest.getAllGenres().size() == 5 && backendToTest.getAllGenres().contains("Horror")
		    && backendToTest.getAllGenres().contains("Action")
		    && backendToTest.getAllGenres().contains("Comedy")
		    && backendToTest.getAllGenres().contains("Musical")
		    && backendToTest.getAllGenres().contains("Romance")) {
		// test passed
		return true;
	    } else {
		// test failed
	      System.out.println(backendToTest.getAllGenres().size());
		return false;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    // test failed
	    return false;
	}
    }

    /**
     * This test instantiates the back end with three movies and tests whether the
     * initial list returned by getThreeMovies starting with the first movie (0) is
     * empty. It passes when 0 is returned and fails in all other cases, including
     * when an exception is thrown.
     * 
     * @return true if the test passed, false if its failed
     */
    public boolean testGetThreeMoviesInitial() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    // TODO: Back End Developer, add at least 2 more tests

    public boolean testAddGenre() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testValidAddRating() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
	    backendToTest.addAvgRating("5");
	    backendToTest.addAvgRating("3");
	    backendToTest.addAvgRating("0");
	    backendToTest.addAvgRating("10");
	    if (!backendToTest.getAvgRatings().contains("5") || !backendToTest.getAvgRatings().contains("3")
		    || !backendToTest.getAvgRatings().contains("0") || !backendToTest.getAvgRatings().contains("10")) {
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

    public boolean testInvalidAddRating() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
	    // Only numbers should be allowed here
	    try {
		backendToTest.addAvgRating("Text");
		if (backendToTest.getAvgRatings().contains("Text")) {
		    return false;
		}
	    } catch (IllegalArgumentException e) {
		// test passed
	    }
	    // Only "0" through "10" should be allowed here, no decimals
	    try {
		backendToTest.addAvgRating("3.1");
		if (backendToTest.getAvgRatings().contains("3.1")) {
		    return false;
		}
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

    public boolean testValidRemoveGenre() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testInvalidRemoveGenre() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
	    backendToTest.addGenre("Visual Tone Poem");
	    try {
		backendToTest.removeGenre("Infrared Spectrum Tone Poem");
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

    public boolean testValidRemoveRating() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));

	    backendToTest.addAvgRating("3");
	    backendToTest.addAvgRating("4");
	    backendToTest.removeAvgRating("3");
	    backendToTest.removeAvgRating("4");

	    if (backendToTest.getAvgRatings().contains("4") || backendToTest.getAvgRatings().contains("3")) {
		return false;
	    }
	    return true;

	} catch (Exception e) {
	    e.printStackTrace();
	    // test failed
	    return false;
	}
    }
    
    public boolean testInvalidRemoveRating() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));

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

	    if (backendToTest.getAvgRatings().contains("4") && backendToTest.getAvgRatings().contains("3")) {
		return true;
	    }
	    return false;

	} catch (Exception e) {
	    e.printStackTrace();
	    // test failed
	    return false;
	}
    }

    public boolean testGetNumberOfMoviesEmptyGenreAllRatings() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testGetNumberOfMoviesSingleGenreAllRatings() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testGetNumberOfMoviesMultipleGenresAllRatings() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testGetNumberOfMoviesMultipleGenresLimitedRatings() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testGetThreeMoviesEmptyGenre() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testGetThreeMoviesOneMovieReturned() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testGetThreeMoviesFullListReturned() {
	try {
	    // instantiate once BackendInterface is implemented
	  BackendInterface backendToTest = new Backend(new StringReader(
          "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
          +
          "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
          +
          "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
          +
          "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
          ));
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

    public boolean testGetThreeMoviesThreeMoviesReturned() {
	try {
	    // instantiate once BackendInterface is implemented
	    BackendInterface backendToTest = new Backend(new StringReader(
						     "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
						     +
						     "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
						     +
						     "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
						     +
						     "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
						     +
						     "Koyaanisqatsi,Koyaanisqatsi,1982,\"Visual Tone Poem, Documentary\",86,USA,English,Godfrey Reggio,\"Ron Fricke, Michael Hoenig, Godfrey Reggio, Alton Walpole\",American Zoetrope,\"None\",\"A collection of expertly photographed phenomena with no conventional plot. The footage focuses on nature, humanity and the relationship between them.\",8.3\n"
						     ));
						    
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
