package com.sprinters.dtos;


import com.sprinters.enums.ApplicationStatus;
import com.sprinters.enums.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
    private UUID applicationId;
    private UUID internshipOfferingId;
    private UUID applicantId;
    private ApplicationStatus applicationStatus;
    private LocalDateTime interviewDateTime;

}
