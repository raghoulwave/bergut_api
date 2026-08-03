package ua.raghoulwave.bergut_api.entity;

import jakarta.persistence.*;
import lombok.*;
import ua.raghoulwave.bergut_api.constants.Provider;
import ua.raghoulwave.bergut_api.constants.SportType;

import java.sql.Timestamp;
import java.util.UUID;

// lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// JPA
@Entity
@Table(name = "activities")
public class Activity extends EntityBergut {

    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID id;

    @Column(
            nullable = false,
            unique = true,
            updatable = false
    )
    private UUID userId;

    @Column(
            nullable = false,
            updatable = false
    )
    private Provider provider;

    @Column(
            nullable = false,
            unique = true,
            updatable = false
    )
    private UUID providerActivityId;

    @Column(
            nullable = false
    )
    private String name;

    @Column(
            nullable = false,
            updatable = false
    )
    private SportType sportType;

    @Column(
            nullable = false,
            updatable = false
    )
    private Double distance;

    @Column(
            nullable = false,
            updatable = false
    )
    private Long movingTime;

    @Column(
            nullable = false,
            updatable = false
    )
    private Long elapsedTime;

    @Column(
            nullable = false,
            updatable = false
    )
    private Double elevationGain;

    @Column(
            nullable = false,
            updatable = false
    )
    private Double averageSpeed;

    @Column(
            nullable = false,
            updatable = false
    )
    private Double maxSpeed;

    @Column(
            nullable = false,
            updatable = false
    )
    private Double averageHour;

    @Column(
            nullable = false,
            updatable = false
    )
    private Double maxHour;

    @Column(
            nullable = false,
            updatable = false
    )
    private Double calories;

    @Column(
            nullable = false,
            updatable = false
    )
    private Timestamp date;

    private String photoUrl;

    @Column(
            nullable = false
    )
    private Boolean visibility;

    @Column(
            nullable = false
    )
    private String rawJson;
}
