package com.sprinters.services;

import com.sprinters.dtos.ApplicationDto;
import com.sprinters.enums.ApplicationStatus;
import com.sprinters.model.Application;
import com.sprinters.repository.ApplicationRepository;
import com.sprinters.utils.exceptions.NotFoundException;
import com.sprinters.utils.mapper.ApplicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;


    public ApplicationDto createApplication(UUID offeringId, UUID studentId) {
        return applicationMapper.entityToDto(applicationRepository.save(
                Application.builder()
                        .internshipOfferingId(offeringId)
                        .applicantId(studentId)
                        .applicationStatus(ApplicationStatus.PENDING)
                        .build()
        ));
    }

    public ApplicationDto getApplication(UUID uuid) {
        return applicationMapper.entityToDto(applicationRepository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Application not found")));
    }

    public List<ApplicationDto> getAllByApplicantId(UUID applicantId) {
        return applicationRepository.findAllByApplicantId(applicantId).stream()
                .map(applicationMapper::entityToDto)
                .toList();
    }

    public List<ApplicationDto> getAllByInternshipOfferingId(UUID internshipOfferingId) {
        return applicationRepository.findAllByInternshipOfferingId(internshipOfferingId).stream()
                .map(applicationMapper::entityToDto)
                .toList();
    }

    public ApplicationDto updateApplication(UUID applicationId, ApplicationDto applicationDto) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new NotFoundException("Application not found"));
        if (applicationDto.getApplicationStatus() != null) {
            application.setApplicationStatus(applicationDto.getApplicationStatus());
        }
        if (applicationDto.getInterviewDateTime() != null) {
            application.setInterviewDateTime(applicationDto.getInterviewDateTime());
        }

        return applicationMapper.entityToDto(applicationRepository.save(application));
    }
}
