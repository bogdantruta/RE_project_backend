package com.sprinters.utils.mapper;

import com.sprinters.dtos.ApplicationDto;
import com.sprinters.dtos.CreateInternshipOfferingDto;
import com.sprinters.dtos.InternshipOfferingDto;
import com.sprinters.model.Application;
import com.sprinters.model.InternshipOffering;
import com.sprinters.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicationMapper {

    ApplicationDto entityToDto(Application application);
    Application dtoToEntity(ApplicationDto applicationDto);
}
