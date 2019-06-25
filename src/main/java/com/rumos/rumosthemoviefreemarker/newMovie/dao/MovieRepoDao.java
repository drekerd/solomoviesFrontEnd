package com.rumos.rumosthemoviefreemarker.newMovie.dao;

import com.rumos.rumosthemoviefreemarker.newMovie.NewMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepoDao extends JpaRepository<NewMovie, Long> {

}
