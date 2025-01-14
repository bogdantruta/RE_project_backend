package com.sprinters.model;

import com.sprinters.enums.ApplicationStatus;
import com.sprinters.enums.Technology;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application")
@Entity
public class Application extends BaseEntity{
    private UUID internshipOfferingId;
    private UUID applicantId;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
    private LocalDateTime interviewDateTime;
}
