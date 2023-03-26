package com.antifraud.transfer;

import lombok.Getter;

@Getter
public enum RejectionReason {
    AMOUNT("too big amount of transfer"),
    CARD_NUMBER("card number prohibited"),
    IP("suspicious ip address"),
    IP_CORRELATION("ip correlation error"),
    NONE("no errors"),
    REGION("invalid region"),
    REGION_CORRELATION("region correlation error"),
    REGION_AND_IP_CORRELATION("region and ip correlation error");

    private final String description;

    RejectionReason(String description) {
        this.description = description;
    }

}
