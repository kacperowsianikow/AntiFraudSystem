package com.antifraud.user.service.appuser;

import com.antifraud.user.dtos.AlterRoleDto;
import com.antifraud.user.dtos.AppUserResponseDto;
import com.antifraud.user.dtos.UnlockAppUserDto;

import java.util.List;

public interface IAppUserService {
    String unlockAppUser(UnlockAppUserDto unlockAppUserDto);
    String alterRole(AlterRoleDto alterRoleDto);
    List<AppUserResponseDto> getAppUsers();
    String deleteUser(Long id);

}
