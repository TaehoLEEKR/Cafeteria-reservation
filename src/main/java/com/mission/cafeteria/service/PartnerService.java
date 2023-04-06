package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.model.Partner;
import com.mission.cafeteria.domain.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public Optional<Partner> findByIdAndEmail(Long id, String email){
        return partnerRepository.findById(id).stream()
                .filter(partner -> partner.getEmail().equals(email)).findFirst();
    }
    public Optional<Partner> findVaildPartner(String email , String password){
        return partnerRepository.findByEmail(email).stream().filter(
                customer -> customer.getPassword().equals(password) && customer.isVerify()
        ).findFirst();
    }

}
