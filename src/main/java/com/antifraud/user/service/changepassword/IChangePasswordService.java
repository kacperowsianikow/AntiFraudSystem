package com.antifraud.user.service.changepassword;

import com.antifraud.user.dtos.ChangePasswordDto;

public interface IChangePasswordService {
    String changePassword(ChangePasswordDto changePasswordDto);

}
