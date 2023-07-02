package com.antifraud.user.service.confirmationtoken;

import com.antifraud.user.ConfirmationToken;
import com.antifraud.user.repository.IConfirmationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService implements IConfirmationTokenService {
    private final IConfirmationTokenRepository iConfirmationTokenRepository;

    public Optional<ConfirmationToken> getTokenByAppUserId(Long appUserId) {
        return iConfirmationTokenRepository.findByAppUserId(appUserId);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return iConfirmationTokenRepository.findByToken(token);
    }

    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        iConfirmationTokenRepository.save(confirmationToken);
    }

    public void setConfirmedAt(String token) {
        iConfirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

    public void updateToken(Long accountId,
                            LocalDateTime createdAt,
                            LocalDateTime expiresAt,
                            String token) {
        iConfirmationTokenRepository.updateToken(accountId, createdAt, expiresAt, token);
    }

}
