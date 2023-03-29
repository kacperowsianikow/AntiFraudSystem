package com.antifraud.service;

import com.antifraud.ips.SuspiciousIp;
import com.antifraud.ips.SuspiciousIpRequest;
import com.antifraud.repository.ISuspiciousIpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuspiciousIpService {
    private final ISuspiciousIpRepository iSuspiciousIpRepository;

    public SuspiciousIp addSuspiciousIp(SuspiciousIpRequest suspiciousIpRequest) {
        Optional<SuspiciousIp> suspiciousIp =
                iSuspiciousIpRepository.findByIp(suspiciousIpRequest.ip());

        if (suspiciousIp.isPresent()) {
            throw new IllegalStateException(
                    "Provided IP address is already in the database"
            );
        }

        SuspiciousIp newSuspiciousIp = new SuspiciousIp(
                suspiciousIpRequest.ip()
        );

        iSuspiciousIpRepository.save(newSuspiciousIp);

        return newSuspiciousIp;
    }

    public List<SuspiciousIp> allSuspiciousIps() {
        return iSuspiciousIpRepository.findAll();
    }

    public String deleteSuspiciousIp(Long id) {
        SuspiciousIp suspiciousIp = iSuspiciousIpRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "There is no IP address with id: " + id
                ));

        iSuspiciousIpRepository.delete(suspiciousIp);

        return "Successfully deleted IP address: " + suspiciousIp.getIp();
    }

}
