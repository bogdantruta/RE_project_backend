package com.sprinters.controller;

import com.sprinters.dtos.ApplicationDto;
import com.sprinters.dtos.CreateInternshipOfferingDto;
import com.sprinters.dtos.InternshipOfferingDto;
import com.sprinters.dtos.UserDto;
import com.sprinters.model.User;
import com.sprinters.security.SecurityContextHolderAdapter;
import com.sprinters.services.InternshipOfferingService;
import com.sprinters.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping(path = "/{offeringId}")
    public InternshipOfferingDto getInternshipOffering(@PathVariable String offeringId) {
        return internshipOfferingService.getInternshipOffering(UUID.fromString(offeringId));
    }

    @PostMapping()
    public InternshipOfferingDto createInternshipOffering(@RequestBody CreateInternshipOfferingDto createInternshipOfferingDto) {
        return internshipOfferingService.createInternshipOffering(createInternshipOfferingDto);
    }
}
