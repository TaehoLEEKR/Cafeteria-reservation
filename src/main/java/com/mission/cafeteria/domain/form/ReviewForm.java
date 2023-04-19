package com.mission.cafeteria.domain.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewForm {
    private Long id;
    private String cname;
    private String content;
    private String phone;
    private String email;
    private float rate;
}
