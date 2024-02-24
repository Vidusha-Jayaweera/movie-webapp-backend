package com.vcoder.moviewebappbackend.service;

import com.vcoder.moviewebappbackend.exceptions.DataNotFoundException;
import com.vcoder.moviewebappbackend.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public Review createReview(String reviewBody, String imdbId) throws DataNotFoundException;
}
