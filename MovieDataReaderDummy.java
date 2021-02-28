// --== CS400 File Header Information ==--
// Author: CS400 Course Staff
// Email: heimerl@cs.wisc.edu / dahl@cs.wisc.edu
// Notes: This dummy class is part of the starter archive for Project One
//        in spring 2021. You can extend it to work on your Project One Final
//        App.

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieDataReaderDummy implements MovieDataReaderInterface {

    /**
     * Method that reads movie data in CSV format from the Redaer provided. The dummy
     * implementations will always return the same 3 sets of movies.
     */
    @Override public List<MovieInterface> readDataSet(Reader inputFileReader)
        throws FileNotFoundException, IOException {
        ArrayList<MovieInterface> movies = new ArrayList<MovieInterface>();

        movies.add(new MovieInterface() {

            @Override public String getTitle() {
                return "Plan 9 from Outer Space";
            }

            @Override public Integer getYear() {
                return 1959;
            }

            @Override public List<String> getGenres() {
                return Arrays.asList(new String[] {"Action", "Comedy"});
            }

            @Override public String getDirector() {
                return "Ed Wood";
            }

            @Override public String getDescription() {
                return "Residents of California's San Fernando Valley are under attack by flying saucers from outer space.";
            }

            @Override public Float getAvgVote() {
                return 5.3f;
            }

            @Override public int compareTo(MovieInterface otherMovie) {
                if (this.getTitle().equals(otherMovie.getTitle())) {
                    return 0;
                    // sort by rating
                } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
                    return +1;
                } else {
                    return -1;
                }
            }

        });

        movies.add(new MovieInterface() {

            @Override public String getTitle() {
                return "The Dirt";
            }

            @Override public Integer getYear() {
                return 2019;
            }

            @Override public List<String> getGenres() {
                return Arrays.asList(new String[] {"Biograpny", "Comedy", "Drama"});
            }

            @Override public String getDirector() {
                return "Jeff Tremaine";
            }

            @Override public String getDescription() {
                return "Based on the bestselling autobiography from Mötley Crüe, the film is an "
                    + "unflinching tale of success and excess as four misfits rise from the "
                    + "streets of Hollywood to the heights of international fame.";
            }

            @Override public Float getAvgVote() {
                return 7.0f;
            }

            @Override public int compareTo(MovieInterface otherMovie) {
                if (this.getTitle().equals(otherMovie.getTitle())) {
                    return 0;
                    // sort by rating
                } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
                    return +1;
                } else {
                    return -1;
                }
            }

        });

        movies.add(new MovieInterface() {

            @Override public String getTitle() {
                return "My Salinger Year";
            }

            @Override public Integer getYear() {
                return 2020;
            }

            @Override public List<String> getGenres() {
                return Arrays.asList(new String[] {"Drama"});
            }

            @Override public String getDirector() {
                return "Philippe Falardeau";
            }

            @Override public String getDescription() {
                return "A college grad takes a clerical job working for the literary agent of "
                    + "the renowned, reclusive writer J.D. Salinger.";
            }

            @Override public Float getAvgVote() {
                return 6.0f;
            }

            @Override public int compareTo(MovieInterface otherMovie) {
                if (this.getTitle().equals(otherMovie.getTitle())) {
                    return 0;
                    // sort by rating
                } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
                    return +1;
                } else {
                    return -1;
                }
            }

        });

        return movies;
    }
}
