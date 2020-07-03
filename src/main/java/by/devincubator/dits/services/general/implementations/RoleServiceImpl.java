package by.devincubator.dits.services.general.implementations;

import by.devincubator.dits.services.general.exception.RoleIdIsIncorrectException;
import by.devincubator.dits.services.general.exception.RoleNameNotFoundException;
import by.devincubator.dits.services.general.interfaces.RoleService;
import by.devincubator.dits.repository.RoleRepository;
import by.devincubator.dits.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

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
