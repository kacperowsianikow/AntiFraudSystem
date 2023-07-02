package com.antifraud.transfer.repository;

import com.antifraud.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findByDateAfter(LocalDateTime date);

}
