package az.ingress.msrelations.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles", schema = "ingress")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY FOR PSQL
    private Long id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<UserEntity> users;

    public RoleEntity(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleEntity that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
