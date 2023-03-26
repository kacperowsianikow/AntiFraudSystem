package com.antifraud.response;

import com.antifraud.appuser.AppUserRole;

import java.util.List;

public record RegistrationResponse(Long id,
                                   String firstname,
                                   String lastname,
                                   String email,
                                   List<AppUserRole> roles) {

}
