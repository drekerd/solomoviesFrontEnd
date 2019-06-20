package com.rumos.rumosthemoviefreemarker.trending.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TrendingController {

    @Autowired
    private TrendingMoviesService trending;

    @GetMapping("/home")
    public String home (Model model){
        model.addAttribute("trending",tablesIdForListing(trending.getMovies()));
        return "home";
    }

    private List<TrendingMoviesFromBE> tablesIdForListing(List<TrendingMoviesFromBE> movies) {
        long tableNumeric = 1;

        for (TrendingMoviesFromBE m : movies) {
            m.setListOnTableID(tableNumeric);
            tableNumeric += +1;
        }
        return movies;
    }

}
