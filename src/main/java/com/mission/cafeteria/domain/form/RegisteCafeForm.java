package com.mission.cafeteria.domain.form;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RegisteCafeForm {
    private String cname;
    private String email;
    private String description;
    private String address;
    private String phone;
    private int count;
    private LocalDateTime restime;

}
