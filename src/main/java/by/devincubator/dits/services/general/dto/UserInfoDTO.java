package by.devincubator.dits.services.general.dto;

import by.devincubator.dits.entities.Role;
import by.devincubator.dits.entities.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class UserInfoDTO {
    @Getter
    private String username;
    private List<RolesEnum> roleList;

    public boolean isUser() {
        return roleList.contains(RolesEnum.ROLE_USER);
    }

    public boolean isAdmin() {
        return roleList.contains(RolesEnum.ROLE_ADMIN);
    }

    public boolean isTutor() {
        return roleList.contains(RolesEnum.ROLE_TUTOR);
    }
}
