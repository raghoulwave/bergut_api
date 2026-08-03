package ua.raghoulwave.bergut_api.entity;

import jakarta.persistence.Version;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

// lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityBergut {

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @Version
    private long version;
}
