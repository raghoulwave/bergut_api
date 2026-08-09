package ua.raghoulwave.bergut_api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "users")
public class User {

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
    private String email;

    @Column(
            nullable = false
    )
    private String password;

    @Column(
            nullable = false
    )
    private String firstname;

    private String lastname;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Version
    private long version;
}
