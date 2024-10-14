package com.sample.spring.api;

import com.sample.spring.api.request.CreateReviewRequest;
import com.sample.spring.service.ReviewService;
import com.sample.spring.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReviewApi {

    private final ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<String> createReview(@RequestBody CreateReviewRequest request) {
        reviewService.createReview(request.getFoodId(), request.getContent(), request.getScore());
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

    @DeleteMapping("/reivew/{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("/food/{foodId}/reviews")
    public ReviewDto getfoodReviews(
            @PathVariable("foodId") Long foodId,
            @RequestParam("offset") Integer offset,
            @RequestParam("limit") Integer limit
    ) {
        return reviewService.getFoodReview(foodId, PageRequest.of(offset/limit, limit));
    }
}
