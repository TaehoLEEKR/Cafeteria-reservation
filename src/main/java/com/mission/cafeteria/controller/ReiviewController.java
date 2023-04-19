package com.mission.cafeteria.controller;

import com.mission.cafeteria.domain.form.ReviewForm;
import com.mission.cafeteria.domain.model.Review;
import com.mission.cafeteria.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@RestController("/customer/reivew")
public class ReiviewController {

    private final ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<String> addReview(@RequestBody ReviewForm form){
        return ResponseEntity.ok(reviewService.createrReview(form));
    }
    @GetMapping
    public ResponseEntity<Optional<Review>> readReview(@RequestParam String cname){
        return ResponseEntity.ok(reviewService.readReivew(cname));
    }
    @PutMapping("/update")
    public ResponseEntity<Review> updateReview(@RequestBody ReviewForm form){
        return  ResponseEntity.ok(reviewService.updateReivew(form.getEmail(),form));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteReview(@RequestBody ReviewForm form){
        reviewService.deleteReivew(form.getEmail(),form.getPhone());
        return ResponseEntity.ok().build();
    }
}
