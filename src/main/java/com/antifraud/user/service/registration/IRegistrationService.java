package com.antifraud.user.service.registration;

import com.antifraud.user.dtos.AppUserRegistrationResponseDto;
import com.antifraud.user.dtos.CreateAppUserDto;

public interface IRegistrationService {
    AppUserRegistrationResponseDto registerAppUser(CreateAppUserDto createAppUserDto);
    String confirmToken(String token);
}
