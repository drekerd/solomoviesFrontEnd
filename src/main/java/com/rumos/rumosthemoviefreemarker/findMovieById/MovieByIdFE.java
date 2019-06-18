package com.rumos.rumosthemoviefreemarker.findMovieById;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class MovieByIdFE {

    private long id;
    private String name;
    private String description;
    private String releaseDate;
    private String popularity;
    private String voteAverage;
    private String tagLine;
    private String thumbnailFullLink;
    private String trailerFulURL;
}
