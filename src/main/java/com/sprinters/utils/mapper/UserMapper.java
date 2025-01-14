package com.sprinters.utils.mapper;

import com.sprinters.dtos.UserDto;
import com.sprinters.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserDto entityToDto(User user, String jwtToken);
}
