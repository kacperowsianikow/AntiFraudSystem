package com.antifraud.user.dtos;

import com.antifraud.user.enums.AppUserRole;

import java.util.List;

public record AppUserRegistrationResponseDto(Long id,
                                             String firstname,
                                             String lastname,
                                             String email,
                                             List<AppUserRole> roles) {

}
