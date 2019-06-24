package com.rumos.rumosthemoviefreemarker.newMovie.dao;

import com.rumos.rumosthemoviefreemarker.newMovie.NewMovie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepoDao extends CrudRepository<NewMovie, Long> {

}
