package com.vcoder.moviewebappbackend.service.impl;

import com.vcoder.moviewebappbackend.exceptions.DataNotFoundException;
import com.vcoder.moviewebappbackend.model.Movie;
import com.vcoder.moviewebappbackend.model.Review;
import com.vcoder.moviewebappbackend.repository.ReviewRepository;
import com.vcoder.moviewebappbackend.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Review createReview(String reviewBody, String imdbId) throws DataNotFoundException {
        logger.info("ReviewServiceImpl -> createReview() => started!");

        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
