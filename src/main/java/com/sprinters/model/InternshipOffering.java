package com.sprinters.model;

import com.sprinters.enums.Technology;
import com.sprinters.enums.UserType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "internship_offering")
@Entity
public class InternshipOffering extends BaseEntity{
    private UUID organizationId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Technology technology;

    private String description;
    private String location;
    private Boolean paid;
    private Boolean closed;
    private Integer minimumPay;
    private Integer maximumPay;
    private Integer durationInMonths;
    private Integer numberOfOpenings;
    private LocalDate startDate;
}
