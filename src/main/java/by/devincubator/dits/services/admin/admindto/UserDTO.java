package by.devincubator.dits.services.admin.admindto;

import by.devincubator.dits.entities.Role;
import by.devincubator.dits.entities.Statistic;
import by.devincubator.dits.services.validation.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String patronymic;

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    private String password;

    private boolean isApproved;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    private List<Role> roleList;

    private List<Statistic> statisticList;


}