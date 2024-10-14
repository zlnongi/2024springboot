package com.sample.spring.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sample.spring.model.QReviewEntity;
import com.sample.spring.model.ReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<ReviewEntity> findSliceByFoodId(Long foodId, Pageable page) {
        List<ReviewEntity> reviews = queryFactory
                .select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.foodId.eq(foodId))
                .offset((long) page.getPageNumber() * page.getPageSize()) // 0page * 10pagesize(페이지개수)
                // offset = 나 여기까지 가져왔어 나는 지금 20번에 해당하는 데이터는 받았어
                .limit(page.getPageSize() + 1) // limit = size
                .fetch();
        return new SliceImpl<>(reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize()
                );
    }
}
