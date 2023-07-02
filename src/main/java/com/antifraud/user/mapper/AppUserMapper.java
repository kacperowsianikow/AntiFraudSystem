package com.antifraud.user.mapper;

import com.antifraud.user.AppUser;
import com.antifraud.user.dtos.AppUserRegistrationResponseDto;
import com.antifraud.user.dtos.AppUserResponseDto;
import com.antifraud.user.dtos.CreateAppUserDto;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {

    public AppUserResponseDto toAppUserResponseDto(AppUser appUser) {
        return new AppUserResponseDto(
                appUser.getId(),
                appUser.getEmail(),
                appUser.getAppUserRoles(),
                appUser.getIsAccountNonLocked()
        );
    }

    public AppUser toAppUser(CreateAppUserDto createAppUserDto) {
        return new AppUser(
                createAppUserDto.firstname(),
                createAppUserDto.lastname(),
                createAppUserDto.email()
        );
    }

    public AppUserRegistrationResponseDto toAppUserRegistrationResponseDto(
            AppUser appUser) {
        return new AppUserRegistrationResponseDto(
                appUser.getId(),
                appUser.getFirstname(),
                appUser.getLastname(),
                appUser.getEmail(),
                appUser.getAppUserRoles()
        );
    }

}
