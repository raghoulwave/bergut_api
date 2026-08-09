package ua.raghoulwave.bergut_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ua.raghoulwave.bergut_api.constants.Provider;

import java.sql.Timestamp;
import java.time.Instant;
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
public class OAuthAccount {

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
    private Long providerUserId;

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
    private Long expiresAt;

    @Column
    private Long expiresIn;

    @Column(
            nullable = false
    )
    private String scope;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Version
    private long version;
}
