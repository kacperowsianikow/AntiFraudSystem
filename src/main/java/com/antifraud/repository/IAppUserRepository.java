package com.antifraud.repository;

import com.antifraud.appuser.AppUser;
import com.antifraud.appuser.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(
            "UPDATE AppUser a " +
                    "SET a.appUserRoles = ?1 " +
                    "WHERE a.email = ?2"
    )
    void updateAppUserRolesByEmail(List<AppUserRole> appUserRoles, String email);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.id = ?1 " +
            "WHERE a.appUserRoles = ?2"
    )
    int updateIdByAppUserRoles(Long id, AppUserRole appUserRoles);

    @Transactional
    @Modifying
    @Query(
            "UPDATE AppUser a " +
                    "SET a.isAccountNonLocked = ?2 " +
                    "WHERE a.email = ?1"
    )
    void unlockAppUser(String email, Boolean isAccountNonLocked);

    @Transactional
    @Modifying
    @Query(
            "UPDATE AppUser a " +
                    "SET a.isEnabled = TRUE " +
                    "WHERE a.email = ?1"
    )
    void enableAppUser(String email);

    @Transactional
    @Modifying
    @Query(
            "UPDATE AppUser a " +
                    "SET a.password = ?2 " +
                    "WHERE a.email = ?1"
    )
    void changePassword(String email, String newPassword);

}
