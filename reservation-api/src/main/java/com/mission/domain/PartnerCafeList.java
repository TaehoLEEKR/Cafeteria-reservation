package com.mission.domain;

import com.mission.domain.AddReservation.AddReservationForm;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerCafeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long masterId;
    @Audited
    private String cname;

    private String phone;
    @Audited
    private String email;

    @ManyToOne
    @JoinColumn(name="pc_id")
    private PartnerCafe partnerCafe;

    public static PartnerCafeList of(Long masterId, AddReservationForm form){
        return PartnerCafeList.builder()
                .cname(form.getCname())
                .masterId(masterId)
                .email(form.getEmail())
                .phone(form.getPhone())

                .build();
    }

}
