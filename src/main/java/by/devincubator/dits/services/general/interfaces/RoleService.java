package by.devincubator.dits.services.general.interfaces;

import by.devincubator.dits.entities.Role;

import java.util.List;

public interface RoleService {
    Role findRoleByRoleId(Integer id);

    Role saveRole(Role role);

    void deleteRole(Role role);

    List<Role> findAllRoles();

    Role findRoleByRoleName(String roleName);
}
