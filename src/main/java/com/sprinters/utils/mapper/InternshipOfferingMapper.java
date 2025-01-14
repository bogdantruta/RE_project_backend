package com.sprinters.utils.mapper;

import com.sprinters.dtos.CreateInternshipOfferingDto;
import com.sprinters.dtos.InternshipOfferingDto;
import com.sprinters.model.InternshipOffering;
import com.sprinters.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface InternshipOfferingMapper {

    @Mapping(target = "organization", source = "organization")
    @Mapping(target = "id", source = "internshipOffering.id")
    InternshipOfferingDto entityToDto(InternshipOffering internshipOffering, User organization);

    InternshipOffering createDtoToEntity(CreateInternshipOfferingDto createInternshipOfferingDto);
}
