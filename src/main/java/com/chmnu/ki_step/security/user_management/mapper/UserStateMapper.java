package com.chmnu.ki_step.security.user_management.mapper;

import com.chmnu.ki_step.security.user_management.persistence.entity.UserState;
import com.chmnu.ki_step.security.user_management.web.dto.DictionaryApiDTO;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserStateMapper {

    @Mappings({
            @Mapping(target = "name", ignore = true)
    })
    UserState mapTo(DictionaryApiDTO source);

    DictionaryApiDTO mapFrom(UserState source);
}
