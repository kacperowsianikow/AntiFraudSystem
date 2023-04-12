package com.antifraud.service;

import com.antifraud.repository.IStolenCardRepository;
import com.antifraud.response.StolenCardResponse;
import com.antifraud.stolencard.StolenCard;
import com.antifraud.stolencard.StolenCardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StolenCardService {
    private final IStolenCardRepository iStolenCardRepository;

    public StolenCardResponse addStolenCard(StolenCardRequest stolenCardRequest) {
        Optional<StolenCard> stolenCard =
                iStolenCardRepository.findByCardNumber(stolenCardRequest.cardNumber());

        if (stolenCard.isPresent()) {
            throw new IllegalStateException(
                    "Card with provided number is already in the database"
            );
        }

        StolenCard newStolenCard = new StolenCard(
                stolenCardRequest.cardNumber()
        );

        iStolenCardRepository.saveAndFlush(newStolenCard);

        return new StolenCardResponse(
                newStolenCard.getId(),
                newStolenCard.getCardNumber()
        );
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

        return "Successfully deleted stolen card with number: " + stolenCard.getCardNumber();
    }

}
