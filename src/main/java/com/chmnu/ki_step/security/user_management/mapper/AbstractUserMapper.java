package com.chmnu.ki_step.security.user_management.mapper;

import com.chmnu.ki_step.security.user_management.persistence.entity.User;
import com.chmnu.ki_step.security.user_management.persistence.repository.UserStateRepository;
import com.chmnu.ki_step.security.user_management.web.dto.UserApiDTO;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserStateMapper.class},
        implementationName = "UserMapperImpl",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public abstract class AbstractUserMapper implements UserMapper {

    private UserStateRepository userStateRepository;

    @Autowired
    public void setUserStateRepository(UserStateRepository userStateRepository) {
        this.userStateRepository = userStateRepository;
    }

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    @Override
    public abstract User mapTo(UserApiDTO source);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true)
    })
    @Override
    public abstract User mergeMapTo(UserApiDTO source, @MappingTarget User target);

    @AfterMapping
    void after(UserApiDTO source, @MappingTarget User target) {
        userStateRepository.findById(source.getState().getId())
                .ifPresent(target::setState);

    }

    @Mappings({
            @Mapping(target = "password", ignore = true),
    })
    @Override
    public abstract UserApiDTO mapFrom(User source);
}
