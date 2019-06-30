package com.rumos.rumosthemoviefreemarker.newMovie;

import com.rumos.rumosthemoviefreemarker.newMovie.dao.MovieRepoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RestController
public class NewMovieController {

    private static final Logger LOGGER = Logger.getLogger(NewMovieController.class.getName());

    @Autowired
    private List<NewMovie> movies;

    @Autowired
    private MovieRepoDao movieRepo;

    @RequestMapping("/add-movie")
    public ModelAndView addNewMovie() {
        return new ModelAndView("addNewMovie");
    }

    @RequestMapping(value = "/add-movie", method = RequestMethod.POST)
    public void setHello(NewMovie movie) {
        System.out.println(movie);
        this.movies.add(movie);
    }

    @RequestMapping(value = "/admin/add-new-movie")
    public ResponseEntity<?> addNewMoviePost(@RequestBody NewMovie movie) {
        System.out.println(movie.toString());
        return checkIfMovieExist(movie);
    }

    @GetMapping("admin/list-movies")
    public ModelAndView getMovies(Model model) {
        this.movies = movieRepo.findAll();
        System.out.println(movieRepo.findAll());
        model.addAttribute("moviesFromDB", this.movies);
        return new ModelAndView("admin");
    }

    @PutMapping(path = "/admin/edit-movie", consumes = {"application/json"})
    public ResponseEntity<?> updateMovie(@RequestBody NewMovie movie) {
        System.out.println(movie.toString());
        movieRepo.save(movie);
        return ResponseEntity.ok(movieRepo.findById(movie.getId()));
    }

    @DeleteMapping(path = "/admin/delete-movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") long id) {
        System.out.println(id);
        movieRepo.deleteById(id);

        return ResponseEntity.ok(id);
    }

    private ResponseEntity<?> checkIfMovieExist(NewMovie movie){

        this.movies = movieRepo.findAll();
        if (this.movies.contains(movie)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicated Entry");
        } else {
            movieRepo.save(movie);
            return ResponseEntity.ok(movie);
        }

    }
}
