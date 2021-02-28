// --== CS400 File Header Information ==--
// Name: William Langas
// Email: wlangas@wisc.edu
// Team: Red
// Group: CC
// TA: Xi Ta
// Lecturer: Gary Dahl

import java.util.List;

public class Movie implements MovieInterface {

    private String title;
    private Integer year;
    private List<String> genres;
    private String director;
    private String description;
    private Float avgVote;

    public Movie(String title, Integer year, List<String> genres, String director, String
            description, Float avgVote) {
        this.title = title;
        this.year = year;
        this.genres = genres;
        this.director = director;
        this.description = description;
        this.avgVote = avgVote;
    }

    public Movie() {

    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Float getAvgVote() {
        return avgVote;
    }

    public void setAvgVote(Float avgVote) {
        this.avgVote = avgVote;
    }

    @Override
    public int compareTo(MovieInterface otherMovie) {
        if (this.getTitle().equals(otherMovie.getTitle())) {
            return 0;
            // sort by rating
        } else if (this.getAvgVote() < otherMovie.getAvgVote()) {
            return +1;
        } else {
            return -1;
        }
    }

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
