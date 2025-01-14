package com.sprinters.controller;

import com.sprinters.dtos.ApplicationDto;
import com.sprinters.dtos.CreateInternshipOfferingDto;
import com.sprinters.dtos.InternshipOfferingDto;
import com.sprinters.model.User;
import com.sprinters.security.SecurityContextHolderAdapter;
import com.sprinters.services.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping(path = "/applicant/{applicantId}")
    public List<ApplicationDto> getAllForApplicant(@PathVariable String applicantId) {
        return applicationService.getAllByApplicantId(UUID.fromString(applicantId));
    }

    @GetMapping(path = "/offering/{offeringId}")
    public List<ApplicationDto> getAllForInternshipOffering(@PathVariable String offeringId) {
        return applicationService.getAllByInternshipOfferingId(UUID.fromString(offeringId));
    }

    @GetMapping(path = "/{applicationId}")
    public ApplicationDto getApplication(@PathVariable String applicationId) {
        return applicationService.getApplication(UUID.fromString(applicationId));
    }

    @PutMapping(path = "/{applicationId}")
    public ApplicationDto updateApplication(@PathVariable String applicationId, @RequestBody ApplicationDto applicationDto) {
        return applicationService.updateApplication(UUID.fromString(applicationId), applicationDto);
    }

    @PostMapping(path = "/offering/{offeringId}")
    public ApplicationDto createApplication(@PathVariable String offeringId) {
        User currentLoggedInUser = SecurityContextHolderAdapter.getCurrentLoggedInUser();

        return applicationService.createApplication(UUID.fromString(offeringId), currentLoggedInUser.getId());
    }
}
