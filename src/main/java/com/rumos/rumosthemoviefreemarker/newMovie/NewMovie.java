package com.rumos.rumosthemoviefreemarker.newMovie;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@Service
@Entity(name = "movies")
public class NewMovie {

    @Id
    private long id;
    private String name;
    private String thumbnailFullLink;
    private String date;
    private String description;

}
