package com.mission.cafeteria.domain.model;

import com.mission.cafeteria.domain.form.RegisteCafeForm;
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

public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long masterid;
    private String cname;
    private String email;
    private String description;
    private String address;
    private String phone;

    public static Cafe from(RegisteCafeForm form){

        return Cafe.builder()
                .cname(form.getCname())
                .email(form.getEmail())
                .description(form.getDescription())
                .address(form.getAddress())
                .phone(form.getPhone())
                .masterid(form.getMasterid())
                .build();
    }
}
