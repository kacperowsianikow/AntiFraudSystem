package com.antifraud.fraud.service.suspiciousip;

import com.antifraud.fraud.dtos.CreateSuspiciousIpDto;
import com.antifraud.fraud.SuspiciousIp;
import com.antifraud.fraud.mapper.FraudMapper;
import com.antifraud.fraud.repository.ISuspiciousIpRepository;
import com.antifraud.fraud.dtos.SuspiciousIpResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuspiciousIpService implements ISuspiciousIpService {
    private final ISuspiciousIpRepository iSuspiciousIpRepository;
    private final FraudMapper fraudMapper;

    public SuspiciousIpResponseDto addSuspiciousIp(
            CreateSuspiciousIpDto createSuspiciousIpDto) {
        Optional<SuspiciousIp> suspiciousIp =
                iSuspiciousIpRepository.findByIp(createSuspiciousIpDto.ip());

        if (suspiciousIp.isPresent()) {
            throw new IllegalStateException(
                    "Provided IP address is already in the database"
            );
        }

        SuspiciousIp newSuspiciousIp =
                fraudMapper.toSuspiciousIp(createSuspiciousIpDto);

        iSuspiciousIpRepository.saveAndFlush(newSuspiciousIp);

        return fraudMapper.toSuspiciousIpResponseDto(newSuspiciousIp);
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
