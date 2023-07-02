package com.antifraud.user.repository;

import com.antifraud.user.AppUser;
import com.antifraud.user.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface IConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByToken(String token);
    Optional<ConfirmationToken> findByAppUserId(Long id);

    @Transactional
    @Modifying
    @Query(
            "UPDATE ConfirmationToken c " +
                    "SET c.confirmedAt = ?2 " +
                    "WHERE c.token = ?1"
    )
    void updateConfirmedAt(String token, LocalDateTime confirmedAt);

    @Transactional
    @Modifying
    @Query(
            "UPDATE ConfirmationToken c " +
                    "SET c.createdAt = ?2, c.expiresAt = ?3, c.token = ?4 " +
                    "WHERE c.id = ?1"
    )
    void updateToken(Long accountId,
                     LocalDateTime createdAt,
                     LocalDateTime expiresAt,
                     String token
    );

    @Transactional
    @Modifying
    void deleteByAppUser(AppUser appUser);

}
