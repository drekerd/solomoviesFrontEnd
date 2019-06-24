package com.rumos.rumosthemoviefreemarker.newMovie;

import com.rumos.rumosthemoviefreemarker.newMovie.dao.MovieRepoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RestController
public class NewMovieController {

    private static final Logger LOGGER = Logger.getLogger(NewMovieController.class.getName());

    @Autowired
    private List<NewMovie> movies;
    private NewMovie movie = new NewMovie();

    @Autowired
    private MovieRepoDao movieRepo;

    @RequestMapping("/add-movie")
    public ModelAndView addNewMovie(){
        return new ModelAndView("addNewMovie");
    }

    @RequestMapping(value="/add-movie", method = RequestMethod.POST)
    public void setHello(NewMovie movie) {
        System.out.println(movie);
        this.movies.add(movie);
    }

    @PostMapping(value="/admin/add-new-movie")
    public ResponseEntity<?> addNewMoviePost(@RequestBody NewMovie movie){
        System.out.println(movie.toString());
        movieRepo.save(movie);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/getMovies")
    public List<NewMovie> helloWorld(Model model) {
        return this.movies;
    }
}
