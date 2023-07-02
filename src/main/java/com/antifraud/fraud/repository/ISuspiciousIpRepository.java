package com.antifraud.fraud.repository;

import com.antifraud.fraud.SuspiciousIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISuspiciousIpRepository extends JpaRepository<SuspiciousIp, Long> {
    Optional<SuspiciousIp> findByIp(String ip);

}
