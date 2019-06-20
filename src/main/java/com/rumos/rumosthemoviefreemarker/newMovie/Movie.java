package com.rumos.rumosthemoviefreemarker.newMovie;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Movie {

    private long id;
    private String name;
    private String description;

}
