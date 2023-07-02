package com.antifraud.fraud.repository;

import com.antifraud.fraud.StolenCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStolenCardRepository extends JpaRepository<StolenCard, Long> {
    Optional<StolenCard> findByCardNumber(String cardNumber);

}
