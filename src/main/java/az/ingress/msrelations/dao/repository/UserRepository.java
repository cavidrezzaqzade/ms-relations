package az.ingress.msrelations.dao.repository;

import az.ingress.msrelations.dao.entity.UserEntity;
import io.swagger.v3.core.util.OpenAPI30To31;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * @author caci
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    @EntityGraph(value = "user-entity-graph")
    @Nonnull
    List<UserEntity> findAll();

    @EntityGraph(attributePaths = "userDetail")
    @Nonnull
    Optional<UserEntity> findById(Long id);


//    @Query("""
//    select ue from UserEntity ue join fetch ue.userDetail
//""")
//    List<UserEntity> findAll2();

}
