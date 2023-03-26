package com.antifraud.stolencard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table
@NoArgsConstructor
public class StolenCard {
    @Id
    @SequenceGenerator(
            name = "stolen_card_sequence",
            sequenceName = "stolen_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stolen_card_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String cardNumber;

    public StolenCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
