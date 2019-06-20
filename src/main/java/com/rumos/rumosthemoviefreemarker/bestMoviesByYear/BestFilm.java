package com.rumos.rumosthemoviefreemarker.bestMoviesByYear;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class BestFilm {
    long id;
    long listOnTableID;
    String name;
    String description;
    String thumbnailFullLink;
}
