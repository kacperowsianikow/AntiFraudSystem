package com.antifraud.fraud.service.stolencard;

import com.antifraud.fraud.dtos.CreateStolenCardDto;
import com.antifraud.fraud.dtos.StolenCardResponseDto;
import com.antifraud.fraud.StolenCard;

import java.util.List;

public interface IStolenCardService {
    StolenCardResponseDto addStolenCard(CreateStolenCardDto createStolenCardDto);
    List<StolenCard> allStolenCards();
    String deleteStolenCard(Long id);

}
