package com.antifraud.user.service.confirmationtoken;

import com.antifraud.user.ConfirmationToken;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IConfirmationTokenService {
    Optional<ConfirmationToken> getTokenByAppUserId(Long appUserId);
    Optional<ConfirmationToken> getToken(String token);
    void saveConfirmationToken(ConfirmationToken confirmationToken);
    void setConfirmedAt(String token);
    void updateToken(Long accountId, LocalDateTime createdAt, LocalDateTime expiresAt, String token);

}
