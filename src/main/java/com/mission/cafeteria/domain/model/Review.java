package com.mission.cafeteria.domain.model;

import com.mission.cafeteria.domain.form.ReviewForm;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String cname;
    private String email;
    private String phone;
    private String content;
    private float rate;

    public static Review from (ReviewForm form){
        return Review.builder()
                .id(form.getId())
                .cname(form.getCname())
                .content(form.getContent())
                .rate(form.getRate())
                .phone(form.getPhone())
                .email(form.getEmail())
                .build();
    }

}
