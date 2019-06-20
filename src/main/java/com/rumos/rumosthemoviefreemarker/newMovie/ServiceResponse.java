package com.rumos.rumosthemoviefreemarker.newMovie;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ServiceResponse {

    private List<Movie> movies= new ArrayList<>();

    @PostMapping("/newMovies")
    public void setHello(@RequestBody Movie movie){
        this.movies.add(movie);
    }

    @GetMapping("/getMovies")
    public List<Movie> helloWorld(Model model) {
        return this.movies;
    }
}
