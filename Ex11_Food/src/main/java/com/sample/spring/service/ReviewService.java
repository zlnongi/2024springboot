package com.sample.spring.service;

import com.sample.spring.repository.FoodRepository;
import com.sample.spring.model.ReviewEntity;
import com.sample.spring.repository.ReviewRepository;
import com.sample.spring.service.dto.ReviewDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final FoodRepository foodRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void createReview(Long foodId, String content, Double score) {
        // foodId값을 찾아야하므로
        foodRepository.findById(foodId).orElseThrow();

        // ReviewEntity review = new ReviewEntity() 원래 이런 형식

        // ReviewEntity의 빌더 사용 시 필드에 맞는 메서드를 설정
        ReviewEntity review = ReviewEntity.builder()
                .foodId(foodId)          // foodId 설정
                .content(content)        // content 설정
                .score(score)            // score 설정
                .createdAt(ZonedDateTime.now())  // 생성 시간 설정
                .build();
        // 리뷰 저장
        reviewRepository.save(review);

    }

    public void deleteReview(Long reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
        reviewRepository.delete(review);
    }

    public ReviewDto getFoodReview(Long foodId, Pageable page ) {
        Double avgScore = reviewRepository.getAvgScoreByFoodId(foodId);

        Slice<ReviewEntity> reviews = reviewRepository.findSliceByFoodId(foodId, page);
        return ReviewDto.builder()
                .avgScore(avgScore)
                .reviews(reviews.getContent())
                .page(
                        ReviewDto.ReviewDtoPage.builder()
                                .offset(page.getPageNumber()* page.getPageSize())
                                .limit(page.getPageSize())
                .build()
                ).build();
    }
}

