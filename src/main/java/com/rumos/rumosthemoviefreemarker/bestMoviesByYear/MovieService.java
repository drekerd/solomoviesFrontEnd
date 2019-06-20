package com.rumos.rumosthemoviefreemarker.bestMoviesByYear;

import java.util.List;
import javax.annotation.PostConstruct;

import java.io.IOException;

import lombok.Data;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;


@Data
@Service
public class MovieService {

    List<BestFilm> movies;
    String backendResponse;


    @PostConstruct
    public void fetchMovies() {

        final String uri = "http://localhost:8080/best/year?year=2008";

        this.backendResponse = callRumosApi(uri);

        this.movies = buildResponse(backendResponse);
    }

    public void getMoviesByYear(String year) {
        String uri;
        if(year!=null)
            uri = "http://localhost:8080/best/year?year="+year;
        else
            uri = "http://localhost:8080/best/year?year=2019";

        this.backendResponse = callRumosApi(uri);

        this.movies = buildResponse(backendResponse);
    }

    private String callRumosApi(final String uri) {

        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(new HttpGet(uri));
            String bodyAsString = EntityUtils.toString(response.getEntity());
            return bodyAsString;
        } catch (IOException e) {
        }
        return "erro";
    }

    public List<BestFilm> buildResponse(String jsonBackendResponse) {

        final List<BestFilm> backendResponseAsObject = new GsonBuilder()
                .create()
                .fromJson(jsonBackendResponse, new TypeToken<List<BestFilm>>(){}.getType());
        return backendResponseAsObject;
    }
}
