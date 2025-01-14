package com.sprinters.services;

import com.sprinters.dtos.CreateInternshipOfferingDto;
import com.sprinters.dtos.InternshipOfferingDto;
import com.sprinters.model.InternshipOffering;
import com.sprinters.repository.InternshipOfferingRepository;
import com.sprinters.repository.UserRepository;
import com.sprinters.utils.exceptions.NotFoundException;
import com.sprinters.utils.mapper.InternshipOfferingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InternshipOfferingService {

    private final InternshipOfferingRepository internshipOfferingRepository;
    private final UserRepository userRepository;
    private final InternshipOfferingMapper internshipOfferingMapper;

    public InternshipOfferingDto getInternshipOffering(UUID uuid) {
        return internshipOfferingRepository.findById(uuid)
                .map(this::mapOffer)
                .orElseThrow(() -> new NotFoundException("Internship offering not found"));
    }

    public List<InternshipOfferingDto> getAllInternshipOfferings() {
        return internshipOfferingRepository.findAll().stream().map(this::mapOffer).toList();
    }

    private InternshipOfferingDto mapOffer(InternshipOffering internshipOffering) {
        return internshipOfferingMapper.entityToDto(internshipOffering,
                userRepository.findById(internshipOffering.getOrganizationId())
                        .orElseThrow(() -> new NotFoundException("Organization not found")));
    }


    public InternshipOfferingDto createInternshipOffering(CreateInternshipOfferingDto createInternshipOfferingDto) {
        return mapOffer(
                internshipOfferingRepository.save(
                        internshipOfferingMapper.createDtoToEntity(createInternshipOfferingDto)
                )
        );
    }

    public List<InternshipOfferingDto> getInternshipOfferingsFiltered(Optional<String> technology,
                                                                      Optional<String> location,
                                                                      Optional<Boolean> paid,
                                                                      Optional<Integer> minimumPay) {
        return internshipOfferingRepository.findAll().stream()
                .filter(internshipOffering -> {
                    if (technology.isPresent() && !technology.get().equals(internshipOffering.getTechnology().name())) {
                        return false;
                    }
                    if (location.isPresent() && !location.get().equals(internshipOffering.getLocation())) {
                        return false;
                    }
                    if (paid.isPresent() && !paid.get().equals(internshipOffering.getPaid())) {
                        return false;
                    }
                    if (minimumPay.isPresent() && minimumPay.get() > internshipOffering.getMinimumPay()) {
                        return false;
                    }
                    return true;
                })
                .map(this::mapOffer)
                .toList();
    }
}
