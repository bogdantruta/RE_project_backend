package com.sprinters.utils.mapper;

import com.sprinters.dtos.CreateInternshipOfferingDto;
import com.sprinters.dtos.InternshipOfferingDto;
import com.sprinters.dtos.UserDto;
import com.sprinters.model.InternshipOffering;
import com.sprinters.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class}, nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface InternshipOfferingMapper {

    InternshipOfferingDto entityToDto(InternshipOffering internshipOffering, User organization);
    InternshipOffering createDtoToEntity(CreateInternshipOfferingDto createInternshipOfferingDto);
}
