package by.devincubator.dits.services.admin.admindto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserForApprovalDTO {

    private String fullName;
    private String login;
    private String email;

}