// --== CS400 File Header Information ==--
// Name: William Langas
// Email: wlangas@wisc.edu
// Team: Red
// Group: CC
// TA: Xi Ta
// Lecturer: Gary Dahl

import java.util.List;

/**
 * This class defines the Movie Object
 *
 * @author willlangas
 */
public class Movie implements MovieInterface {

    private String title;
    private Integer year;
    private List<String> genres;
    private String director;
    private String description;
    private Float avgVote;

    /**
     * Full constructor
     *
     * @param title Movie title
     * @param year Year of release
     * @param genres List of genres
     * @param director Director(s)
     * @param description Description of the movie
     * @param avgVote The float value average rating
     */
    public Movie(String title, Integer year, List<String> genres, String director, String
            description, Float avgVote) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.director = director;
        this.description = description;
        this.avgVote = avgVote;
    }

    /**
     * Default Constructor
     */
    public Movie() {

    }

    /**
     * Returns the movie title
     *
     * @return title The movie title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the movie
     *
     * @param title The movie title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the movie's release year
     *
     * @return The year of release
     */
    @Override
    public Integer getYear() {
        return year;
    }

    /**
     * Set the year of release
     *
     * @param year The year of release
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Returns a list of the movie's genres
     *
     * @return The list of genres
     */
    @Override
    public List<String> getGenres() {
        return genres;
    }

    /**
     * Sets the genres
     *
     * @param genres The list of genres
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /**
     * Returns the movie's directors
     *
     * @return The director(s)
     */
    @Override
    public String getDirector() {
        return director;
    }

    /**
     * Set the movie's director(s)
     *
     * @param director The director(s)
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Returns the movie's description
     *
     * @return The movie's description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the movie
     *
     * @param description The movie's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the average rating of the movie
     *
     * @return The average rating of the movie
     */
    @Override
    public Float getAvgVote() {
        return avgVote;
    }

    /**
     * Set the average rating of the movie
     *
     * @param avgVote The average rating of the movie
     */
    public void setAvgVote(Float avgVote) {
        this.avgVote = avgVote;
    }

    /**
     * Compares two movies based on their average rating
     * 
     * @param otherMovie The movie to compare to
     * @return 0 if the ratings are equal, -1 if the new movie is higher rated, +1 otherwise
     */
    @Override
    public int compareTo(MovieInterface otherMovie) {
        if (this.getTitle().equals(otherMovie.getTitle())) {
            return 0;
            // sort by rating
        } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
            return -1;
        } else {
            return +1;
        }
    }

    /**
     * Returns a formatted string representation of the movie object
     * 
     * @return A string representation of the movie
     */
    @Override
    public String toString() {
        String movie = this.title;
        movie += " (" + this.year + ") | " + "Dir. By: " + this.director + " |";
        movie += " Genres: ";
        for (int i = 0; i < this.genres.size(); ++i) {
            movie += " " + this.genres.get(i);
        }
        movie += " | " + this.description;
        movie += " | " + this.avgVote;
        return movie;
    }
}
