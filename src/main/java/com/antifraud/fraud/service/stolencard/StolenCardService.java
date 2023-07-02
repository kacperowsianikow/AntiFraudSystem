package com.antifraud.fraud.service.stolencard;

import com.antifraud.fraud.mapper.FraudMapper;
import com.antifraud.fraud.repository.IStolenCardRepository;
import com.antifraud.fraud.dtos.StolenCardResponseDto;
import com.antifraud.fraud.StolenCard;
import com.antifraud.fraud.dtos.CreateStolenCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StolenCardService implements IStolenCardService {
    private final IStolenCardRepository iStolenCardRepository;
    private final FraudMapper fraudMapper;

    public StolenCardResponseDto addStolenCard(
            CreateStolenCardDto createStolenCardDto) {
        Optional<StolenCard> stolenCard =
                iStolenCardRepository.findByCardNumber(
                        createStolenCardDto.cardNumber()
                );

        if (stolenCard.isPresent()) {
            throw new IllegalStateException(
                    "Card with provided number is already in the database"
            );
        }

        StolenCard newStolenCard =
                fraudMapper.toStolenCard(createStolenCardDto);

        iStolenCardRepository.saveAndFlush(newStolenCard);

        return fraudMapper.toStolenCardResponseDto(newStolenCard);
    }

    public List<StolenCard> allStolenCards() {
        return iStolenCardRepository.findAll();
    }

    public String deleteStolenCard(Long id) {
        StolenCard stolenCard = iStolenCardRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "There is no card with id: " + id
                ));

        iStolenCardRepository.delete(stolenCard);

        return "Successfully deleted stolen card with number: "
                + stolenCard.getCardNumber();
    }

}
