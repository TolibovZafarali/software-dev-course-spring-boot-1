package com.example.mycollections.controllers;

import com.example.mycollections.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {

    private final List<Movie> movies = new ArrayList<>() {{
       add(new Movie("War and Peace", "Tom Harper", 2016, 354));
       add(new Movie("The Maze Runner", "Wes Ball", 2014, 113));
       add(new Movie("Succession", "Mark Mylod", 2018, 58));
    }};

    @GetMapping("/json")
    public List<Movie> getMoviesJson() { return movies; }

    @GetMapping("/html")
    public String getMoviesHtml() {
        String movieList = "<ul>";
        for (Movie movie : movies) {
            movieList += "<li>" + movie.getName() + movie.getYear() + "</li>";
        }

        movieList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Movies</h1>
                        <ul>
                """ +
                movieList +
                """
                        </ul>
                    </body>
                """;
    }
}
