package com.rumos.rumosthemoviefreemarker.newMovie;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Data
@ToString
@Service
public class NewMovie {

    private long id;
    private String name;
    private String description;

}
