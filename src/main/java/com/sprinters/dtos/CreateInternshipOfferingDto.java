package com.sprinters.dtos;


import com.sprinters.enums.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateInternshipOfferingDto {
    private UUID organizationId;
    private String name;
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
