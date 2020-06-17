package by.devincubator.repository;

//import by.devincubator.entities.Role;
import by.devincubator.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
    Optional<Role> findRoleByRoleName(String roleName);

}
