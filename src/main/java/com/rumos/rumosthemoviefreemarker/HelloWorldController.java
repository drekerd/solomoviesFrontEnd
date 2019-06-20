

package com.rumos.rumosthemoviefreemarker;

import com.rumos.rumosthemoviefreemarker.bestMoviesByYear.BestFilm;
import com.rumos.rumosthemoviefreemarker.bestMoviesByYear.MovieService;
import com.rumos.rumosthemoviefreemarker.findMovieById.MovieByIdFE;
import com.rumos.rumosthemoviefreemarker.findMovieById.MovieServiceFE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    private String eu = "cenas";


    @RequestMapping("/test")
    public String testHello(){
        return "helloTest";
    }

    @RequestMapping(value="/time", method = RequestMethod.POST)
    @ResponseBody
    public String getHello(@RequestParam(required=false, name="name") String name){
        Date date = new Date();
        System.out.println("----"+name+" "+ date+"----");
        this.eu = name;
        System.out.println("value " + this.eu + " was set to "+ name);
        return this.eu;
    }

    @RequestMapping("/getMe")
    @ResponseBody
    public String getMe(){
        System.out.println("eu "+eu);
        return this.eu;
    }

    @GetMapping("/solomovies")
    public String helloWorld(Model model) {
        model.addAttribute("moviesFromBackend", tablesIdForListing(service.getMovies()));
        return "hello-world";
    }

    @RequestMapping(method=RequestMethod.GET, value="/getBestMovies")
    @ResponseBody
    public ModelAndView getBestMovies(Model model, @RequestParam(required=false, name="year") String year){
        model.addAttribute("moviesFromBackend", tablesIdForListing(service.getMoviesByYear(year)));
        System.out.println("year "+year);
        return new ModelAndView("hello-world");
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
