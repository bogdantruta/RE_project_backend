package com.sprinters.dtos;


import com.sprinters.enums.Technology;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InternshipOfferingDto {
    private UUID id;
    private UserDto organization;
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
