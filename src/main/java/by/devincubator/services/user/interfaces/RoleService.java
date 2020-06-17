package by.devincubator.services.user.interfaces;

import by.devincubator.entities.Role;

public interface RoleService {
    Role findRoleByRoleId(Integer id);
    Role saveRole(Role role);
    void deleteRole(Role role);
}
