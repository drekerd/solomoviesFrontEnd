package com.rumos.rumosthemoviefreemarker.trending.movies;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Data
@Service
public class TrendingMoviesService {

    private static final Logger LOGGER = Logger.getLogger(TrendingMoviesService.class.getName());

    List<TrendingMoviesFromBE> movies;
    String backendResponse;

    @PostConstruct
    public void fetchMovies() {

        final String uri = "http://localhost:8080/trending/movie";
        this.backendResponse = callRumosApi(uri);
        this.movies = buildResponse(backendResponse);
        LOGGER.info("Calling BACKEND: "+uri);
    }

    private String callRumosApi(final String uri) {

        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(new HttpGet(uri));
            String bodyAsString = EntityUtils.toString(response.getEntity());
            return bodyAsString;
        } catch (IOException e) {
        }
        return "error";
    }

    public List<TrendingMoviesFromBE> buildResponse(String jsonBackendResponse) {

        final List<TrendingMoviesFromBE> backendResponseAsObject = new GsonBuilder()
                .create()
                .fromJson(jsonBackendResponse, new TypeToken<List<TrendingMoviesFromBE>>(){
                }.getType());
        return backendResponseAsObject;
    }
}
