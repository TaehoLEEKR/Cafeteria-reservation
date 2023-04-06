package com.mission.cafeteria.domain.model;

import com.mission.cafeteria.domain.RegisteCafeForm;
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

    private String cname;
    private String address;
    private String phone;
    private String master;

    public static Cafe from(RegisteCafeForm form){

        return Cafe.builder()
                .cname(form.getCname())
                .address(form.getAddress())
                .phone(form.getPhone())
                .master(form.getMaster())
                .build();
    }
}
