package com.vcoder.moviewebappbackend.service;

import com.vcoder.moviewebappbackend.exceptions.DataNotFoundException;
import com.vcoder.moviewebappbackend.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    public List<Movie> allMovies() throws DataNotFoundException;
    public Optional<Movie> movieById(String imdbId) throws DataNotFoundException;
}
