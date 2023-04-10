package com.mission.domain;

import com.mission.domain.AddReservation.AddReservationForm;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class PartnerCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long masterId;
    private String name;
    private String phone;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pc_id")
    private List<PartnerCafeList> partnerCafeItems = new ArrayList<>();

    public static PartnerCafe of(Long masterId, AddReservationForm form){
        return PartnerCafe.builder()
                .masterId(masterId)
                .name(form.getCname())
                .phone(form.getPhone())
                .email(form.getEmail())
                .partnerCafeItems(form.getItems().stream()
                        .map(pi->PartnerCafeList.of(masterId,pi)).collect(Collectors.toList()))
                .build();

    }
}
