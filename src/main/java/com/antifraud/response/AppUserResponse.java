package com.antifraud.response;

import com.antifraud.appuser.AppUserRole;

import java.util.List;

public record AppUserResponse(
        Long id,
        String email,
        List<AppUserRole> roles,
        Boolean isAccountNonLocked) {

}
