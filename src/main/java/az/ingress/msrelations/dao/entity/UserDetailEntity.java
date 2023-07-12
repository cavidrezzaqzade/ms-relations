package az.ingress.msrelations.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;

import static jakarta.persistence.FetchType.LAZY;

/**
 * @author caci
 * @since 19.05.2022
 */

@ToString
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details", schema = "ingress")
public class UserDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;

    @Column(name = "address", nullable = false, unique = true)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToOne(fetch = LAZY)
    @MapsId
    @JoinColumn(name = "id")
    @ToString.Exclude
    private UserEntity user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetailEntity that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
