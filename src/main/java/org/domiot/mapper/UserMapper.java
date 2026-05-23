package org.domiot.mapper;

import org.domiot.entities.UserEntity;
import org.domiot.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {

    @Mapping(target = "emailAddress", source = "email")
    User map(UserEntity user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", source = "emailAddress")
    UserEntity map(User user);
}
