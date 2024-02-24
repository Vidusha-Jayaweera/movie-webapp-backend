package com.vcoder.moviewebappbackend.service.impl;

import com.vcoder.moviewebappbackend.exceptions.DataNotFoundException;
import com.vcoder.moviewebappbackend.model.Movie;
import com.vcoder.moviewebappbackend.repository.MovieRepository;
import com.vcoder.moviewebappbackend.service.MovieService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> allMovies() throws DataNotFoundException {
        logger.info("MovieServiceImpl -> allMovies() => started!");
        return movieRepository.findAll();
    }
    @Override
    public Optional<Movie> movieById(String imdbId) throws DataNotFoundException{
        logger.info("MovieServiceImpl -> movieById() => started!");
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
