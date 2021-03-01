// --== CS400 File Header Information ==--
// Name: William Langas
// Email: wlangas@wisc.edu
// Team: Red
// Group: CC
// TA: Xi Ta
// Lecturer: Gary Dahl

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDataReader implements MovieDataReaderInterface {

    /**
     * Default constructor
     */
    public MovieDataReader() {
    }

    /**
     * Takes a string reader and returns a list of Movie objects from the formatted CSV
     *
     * @param inputFileReader The reader to be used to parse the data
     * @return movies The list of movies
     * @throws FileNotFoundException If the input file is not found
     * @throws IOException If there is an issue with the scanner
     */
    @Override public List<MovieInterface> readDataSet(Reader inputFileReader)
        throws FileNotFoundException, IOException {

        // List of movie objects
        List<MovieInterface> movies = new ArrayList<MovieInterface>(0);

        try {
            Scanner fileScnr = new Scanner(inputFileReader); // Create an "outside level" scanner to read lines
            fileScnr.nextLine(); // Remove the columns headers

            // Now loop once for each line
            while (fileScnr.hasNextLine()) {
                String line = fileScnr.nextLine();  // Grab the whole line
                Scanner scnr = new Scanner(line); // Create an "inside" scnr for parsing the line
                scnr.useDelimiter(",");
                Movie newMovie = new Movie(); // Create a new movie object to be added

                // Grab the title, which could have commas in it
                String title = "";
                String firstWord = scnr.next();
                // If it starts with a ", must be looped through until a second " is found
                if (firstWord.startsWith("\"")) {
                    firstWord = firstWord.replace("\"", "");
                    title += firstWord + ", ";

                    String next = scnr.next();
                    while (!next.endsWith("\"")) {
                        title += ", " + next; // Replace the comma
                        next = scnr.next();
                    }

                    next = next.replace("\"", "");
                    title += next;
                    newMovie.setTitle(title);
                } else {
                    newMovie.setTitle(firstWord); // Set the title for the object
                }

                // Skip past the original title, which also might have commas
                String first = scnr.next();
                if (first.startsWith("\"")) {
                    String next = scnr.next();
                    while (!next.endsWith("\"")) {
                        next = scnr.next();
                    }
                }

                // Grab the year
                String year = scnr.next();
                newMovie.setYear(Integer.parseInt(year));

                // Now the genre, adding each genre to a list of Strings
                List<String> genres = new ArrayList<String>(0);
                first = scnr.next();
                if (first.startsWith("\"")) {
                    first = first.replace("\"", "");
                    genres.add(first);

                    String next = scnr.next();
                    while (!next.endsWith("\"")) {
                        genres.add(next);
                        next = scnr.next();
                    }

                    next = next.replace("\"", "");
                    genres.add(next);

                    for (int i = 0; i < genres.size(); ++i) {
                        String original = genres.get(i);
                        String trimmed = original.trim();
                        genres.set(i, trimmed);
                    }

                    newMovie.setGenres(genres);
                } else {
                    genres.add(first);
                    newMovie.setGenres(genres);
                }

                // Skip the runtime, country, and language
                scnr.next(); // Runtime

                first = scnr.next(); // Country (could be multiple
                if (first.startsWith("\"")) {
                    String next = scnr.next();
                    while (!next.endsWith("\"")) {
                        next = scnr.next();
                    }
                }

                scnr.next(); // Language

                // Grab the director(s)
                String directors = "";
                first = scnr.next();
                if (first.startsWith("\"")) {
                    first = first.replace("\"", "");
                    directors += first + ", ";

                    String next = scnr.next();
                    while (!next.endsWith("\"")) {
                        directors += ", " + next;
                        next = scnr.next();
                    }

                    next = next.replace("\"", "");
                    next = next.trim();
                    directors += next;
                    newMovie.setDirector(directors);
                } else {
                    newMovie.setDirector(first);
                }

                // We need to skip over the writers, which could be multiple
                first = scnr.next();
                if (first.startsWith("\"")) {
                    String next = scnr.next();
                    while (!next.endsWith("\"")) {
                        next = scnr.next();
                    }
                }
                // Now skip over the Production company
                scnr.next();

                // Now skip over the actors
                first = scnr.next();
                if (first.startsWith("\"")) {
                    String next = scnr.next();
                    while (!next.endsWith("\"")) {
                        next = scnr.next();
                    }
                }

                // Grab the description, which is just like getting the genres but add back in commas
                String description = scnr.next();
                if (description.startsWith("\"")) {
                    description = description.replace("\"", "");
                    String next = scnr.next();

                    while (!next.endsWith("\"")) {
                        description += "," + next;
                        next = scnr.next();
                    }

                    next = next.replace("\"", "");
                    description += next;
                    newMovie.setDescription(description);
                } else { // If there are no commas in the description
                    newMovie.setDescription(description);
                }
                // Lastly, grab the float value of the avgVote
                String avgVoteStr = scnr.next();
                Float avgVote = Float.parseFloat(avgVoteStr);
                newMovie.setAvgVote(avgVote);

                movies.add(newMovie); // Add the movie to the list of movies
                scnr.close();   // Close the inside scanner to avoid memory leaks or other issues
            }
        }  catch (Exception e) {
            System.out.println("Exception " + e + "caught");
            e.printStackTrace();
        }
        return movies;
    }
}
