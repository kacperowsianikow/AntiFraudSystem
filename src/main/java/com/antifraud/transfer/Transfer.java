package com.antifraud.transfer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table
@NoArgsConstructor
public class Transfer {
    @Id
    @SequenceGenerator(
            name = "transfer_sequence",
            sequenceName = "transfer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transfer_sequence"
    )
    private Long id;
    private Long amount;
    private String ip;
    private String cardNumber;
    private String region;
    private LocalDateTime date;

    public Transfer(Long amount,
                    String ip,
                    String cardNumber,
                    String region,
                    LocalDateTime date) {
        this.amount = amount;
        this.ip = ip;
        this.cardNumber = cardNumber;
        this.region = region;
        this.date = date;
    }

}
