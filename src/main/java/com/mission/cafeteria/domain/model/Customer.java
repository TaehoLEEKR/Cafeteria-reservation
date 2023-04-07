package com.mission.cafeteria.domain.model;

import com.mission.cafeteria.domain.form.SignUpForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String name;
    private String password;
    private String phone;
    private LocalDateTime customerDt;

    private String verificationCode;

    private boolean customer_verify; // 고객 email 승인

    public static Customer from (SignUpForm form){
        return Customer.builder()
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .password(form.getPassword())
                .name(form.getName())
                .phone(form.getPhone())
                .customer_verify(false)
                .build();
    }
}
