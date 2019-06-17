package com.rumos.rumosthemoviefreemarker.bestMoviesByYear;

import lombok.Data;

@Data
public class BestFilm {
    long id;
    long listOnTableID;
    String name;
    String description;
    String thumbnailFullLink;
}
