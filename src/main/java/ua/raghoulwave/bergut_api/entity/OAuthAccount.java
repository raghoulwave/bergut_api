package ua.raghoulwave.bergut_api.entity;

import jakarta.persistence.*;
import lombok.*;
import ua.raghoulwave.bergut_api.constants.Provider;

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
@Table(name = "oauth_accounts")
public class OAuthAccount extends EntityBergut {

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
            updatable = false
    )
    private UUID providerUserId;

    @Column(
            nullable = false
    )
    private String accessToken;

    @Column(
            nullable = false
    )
    private String refreshToken;

    @Column(
            nullable = false
    )
    private Timestamp expiresAt;

    @Column(
            nullable = false
    )
    private String scope;
}
