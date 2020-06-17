package by.devincubator.services.user.implementations;

import by.devincubator.repository.RoleRepository;
import by.devincubator.entities.Role;
import by.devincubator.services.user.exceptions.RoleIdIsIncorrectException;
import by.devincubator.services.user.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleId(Integer id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleIdIsIncorrectException(id));
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName)
                .orElseThrow(() -> new RoleNameNotFoundException("There is no role with the name " + roleName));
    }
}
