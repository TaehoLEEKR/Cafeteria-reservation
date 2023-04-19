package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.form.ReviewForm;
import com.mission.cafeteria.domain.model.Review;
import com.mission.cafeteria.domain.model.redis.Restaurant;
import com.mission.cafeteria.domain.model.redisRepository.ReservationRepository;
import com.mission.cafeteria.domain.repository.ReviewRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.cafeteria.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewApplication {
//    private final ReviewRepository reviewRepository;
//    private final ReviewService reviewService;
//    private final ReservationRepository reservationRepository;
//
//
//    @Transactional
//    public String createrReview(ReviewForm form){
//        // 방문 고객 이였는지 체크
//        // 이미 작성한 고객이라면 수정 요구
//        Restaurant restaurant = reservationRepository.findByEmailAndPhone(form.getEmail() , form.getPhone());
//        if(!reviewService.isCheckVisit(restaurant)) {
//            // 리뷰 작성
//            reviewService.reviewRegist(form);
//        }else if (reviewRepository.findByPhone(form.getPhone()).isPresent()){
//            return "이미 작성한 기록이 있습니다." +
//                    "수정을 원하시면 아래 링크로 수정해 주세요" +
//                    "http://localhost:8081/customer/review/update";
//        }
//        return "정보를 확인해 주세요";
//    }
//    public Review updateReivew(Long reviewId, ReviewForm form) {
//        //방문고객 확인
//        Review r = reviewRepository.findByIdAndPhone(reviewId, form.getPhone())
//                .orElseThrow(() -> new PartnerException(ErrorCode.NOT_USE_CAFE));
//        r.setContent(form.getContent());
//        r.setRate(form.getRate());
//        return reviewRepository.save(r);
//    }
//    public Optional<Review> readReivew(String cname) // 해당 매장 리뷰 READ
//    {
//        return reviewRepository.findByCname(cname);
//    }
//    @Transactional
//    public void deleteReivew(Long reviewId, String phone){
//        Review review = reviewRepository.findByIdAndPhone(reviewId,phone)
//                .orElseThrow(()->new PartnerException(ErrorCode.NOT_USE_CAFE));
//        reviewRepository.delete(review);
//    }
}
