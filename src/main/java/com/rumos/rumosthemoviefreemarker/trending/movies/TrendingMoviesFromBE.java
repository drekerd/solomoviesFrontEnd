package com.rumos.rumosthemoviefreemarker.trending.movies;

import lombok.Data;

@Data
public class TrendingMoviesFromBE {
    private long id;
    private long listOnTableID;
    private String name;
    private String description;
    private String thumbnailFullLink;
}
