

package com.rumos.rumosthemoviefreemarker;

import com.rumos.rumosthemoviefreemarker.bestMoviesByYear.BestFilm;
import com.rumos.rumosthemoviefreemarker.bestMoviesByYear.MovieService;
import com.rumos.rumosthemoviefreemarker.findMovieById.MovieByIdFE;
import com.rumos.rumosthemoviefreemarker.findMovieById.MovieServiceFE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HelloWorldController {

    @Autowired
    private MovieService service;
    @Autowired
    private List<BestFilm> bestFilm;
    @Autowired
    private MovieServiceFE movieServiceDetails;
    @Autowired
    private MovieByIdFE movieByIdFE;


    @RequestMapping("/test")
    public String testHello(){
        return "helloTest";
    }

    @RequestMapping("/time")
    @ResponseBody
    public String getHello(){
        Date date = new Date();
        return "hello "+ date;
    }

    @GetMapping("/solomovies")
    public String helloWorld(Model model) {
        model.addAttribute("key", "rumos");
        model.addAttribute("moviesFromBackend", service.getMovies());
        return "hello-world";
    }

    @PostMapping("/solomovies")
    public String hello(Model model, String year) {
        service.getMoviesByYear(year);
        model.addAttribute("moviesFromBackend", service.getMovies());
        return "hello-world";
    }

    @GetMapping("/details/{id}")
    public String getId(Model model, @PathVariable long id) {
        movieByIdFE = movieServiceDetails.fetchMovies(id);
        System.out.println(id);
        model.addAttribute("movie", movieByIdFE);
        return "details";
    }

    @GetMapping("/new-movie")
    public String getMovie() {
        return "new-movie";
    }



    @PostConstruct
    private void setTableIds() {
        tablesIdForListing(service.getMovies());
    }

    private List<BestFilm> tablesIdForListing(List<BestFilm> movies) {
        long tableNumeric = 1;

        for (BestFilm m : movies) {
            m.setListOnTableID(tableNumeric);
            tableNumeric += +1;
        }
        return movies;
    }
}
