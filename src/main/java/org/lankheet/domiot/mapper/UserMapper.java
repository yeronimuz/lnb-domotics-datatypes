package org.lankheet.domiot.mapper;

import org.lankheet.domiot.entities.UserEntity;
import org.lankheet.domiot.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {

    User map(UserEntity user);

    @Mapping(target = "id", ignore = true)
    UserEntity map(User user);
}
