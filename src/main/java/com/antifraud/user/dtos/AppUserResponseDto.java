package com.antifraud.user.dtos;

import com.antifraud.user.enums.AppUserRole;

import java.util.List;

public record AppUserResponseDto(Long id,
                                 String email,
                                 List<AppUserRole> roles,
                                 Boolean isAccountNonLocked) {

}
