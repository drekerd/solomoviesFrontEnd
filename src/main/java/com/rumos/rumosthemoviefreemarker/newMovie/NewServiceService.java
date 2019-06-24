package com.rumos.rumosthemoviefreemarker.newMovie;

import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Data
@RestController
public class NewServiceService {

    private List<NewMovie> newMovies;

}
