

package com.rumos.rumosthemoviefreemarker;

import com.rumos.rumosthemoviefreemarker.bestMoviesByYear.BestFilm;
import com.rumos.rumosthemoviefreemarker.bestMoviesByYear.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    private MovieService service;

    @GetMapping("/solomovies")
    public String helloWorld(Model model) {
        model.addAttribute("key", "rumos");
        model.addAttribute("moviesFromBackend", service.getMovies());
        return "hello-world";
    }

    @GetMapping("/details")
    public String getId(Model model, @RequestParam(value="id") long id) {
        model.addAttribute("key", "rumos");
        model.addAttribute("moviesFromBackend", service.getMovies());
        return "hello-world";
    }

    @PostConstruct
    private void setTableIds(){
        tablesIdForListing(service.getMovies());
    }

    private List<BestFilm> tablesIdForListing(List<BestFilm> movies){
        long tableNumeric = 1;

        for(BestFilm m:movies){
            m.setListOnTableID(tableNumeric);
            tableNumeric += +1;
        }
        return movies;
    }
}
