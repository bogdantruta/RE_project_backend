package com.sprinters.controller;

import com.sprinters.dtos.CreateInternshipOfferingDto;
import com.sprinters.dtos.InternshipOfferingDto;
import com.sprinters.services.InternshipOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/internship-offering")
public class InternshipOfferingController {
    private final InternshipOfferingService internshipOfferingService;

    @GetMapping()
    public List<InternshipOfferingDto> getAll() {
        return internshipOfferingService.getAllInternshipOfferings();
    }

    @GetMapping(path = "/filter")
    public List<InternshipOfferingDto> getOfferingsFiltered(@RequestParam("technology") Optional<String> technology,
                                                            @RequestParam("location") Optional<String> location,
                                                            @RequestParam("paid") Optional<Boolean> paid,
                                                            @RequestParam("minimumPay") Optional<Integer> minimumPay){
        return internshipOfferingService.getInternshipOfferingsFiltered(technology, location, paid, minimumPay);
    }

    @GetMapping(path = "/{offeringId}")
    public InternshipOfferingDto getInternshipOffering(@PathVariable String offeringId) {
        return internshipOfferingService.getInternshipOffering(UUID.fromString(offeringId));
    }

    @PostMapping()
    public InternshipOfferingDto createInternshipOffering(@RequestBody CreateInternshipOfferingDto createInternshipOfferingDto) {
        return internshipOfferingService.createInternshipOffering(createInternshipOfferingDto);
    }
}
