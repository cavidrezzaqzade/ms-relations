package az.ingress.msrelations.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@NamedEntityGraph(
        name = "user-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("roles"),
                @NamedAttributeNode("userDetail"),
                @NamedAttributeNode("tasks")
        }
)
@ToString
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "ingress")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(
            cascade = PERSIST,
            mappedBy = "user",
            fetch = LAZY)
    @ToString.Exclude
    private UserDetailEntity userDetail;

    @ManyToMany(/*cascade = {PERSIST,MERGE}*/)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
    )
    @ToString.Exclude
    @Builder.Default
    private Set<RoleEntity> roles = new HashSet<>();

    @OneToMany(
            mappedBy = "user"/*,
            cascade = ALL*/
    )
    @ToString.Exclude
    private List<TaskEntity> tasks = new ArrayList<>();

    public UserEntity(Long id) {
        this.id = id;
    }

    public void addRole(RoleEntity roleEntity) {
        roles.add(roleEntity);
        roleEntity.getUsers().add(this);
    }

    public void removeRole(RoleEntity roleEntity) {
        roles.remove(roleEntity);
        roleEntity.getUsers().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
