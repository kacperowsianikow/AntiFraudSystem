package com.antifraud.ips;

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
public class SuspiciousIp {
    @Id
    @SequenceGenerator(
            name = "suspicious_ip_sequence",
            sequenceName = "suspicious_ip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "suspicious_ip_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String ip;

    public SuspiciousIp(String ip) {
        this.ip = ip;
    }

}
