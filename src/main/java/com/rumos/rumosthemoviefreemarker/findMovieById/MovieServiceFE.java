package com.rumos.rumosthemoviefreemarker.findMovieById;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Serializable;


@Data
@Controller
public class MovieServiceFE implements Serializable {

    @Autowired
    private MovieByIdFE movie;
    String backendResponse;

    String movieID;

    @PostConstruct
    public void fetchMovies() {

        final String uri = "http://localhost:8080/details/movie?id=" + movieID;
        this.backendResponse = callRumosApi(uri);
        this.movie = buildResponse(backendResponse);
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

    public MovieByIdFE buildResponse(String jsonBackendResponse) {

        final MovieByIdFE backendResponseAsObject = new GsonBuilder()
                .create()
                .fromJson(jsonBackendResponse, new TypeToken<MovieByIdFE>() {
                }.getType());
        return backendResponseAsObject;
    }
}
