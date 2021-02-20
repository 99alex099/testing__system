package by.devincubator.dits.services.admin.admindto;

import by.devincubator.dits.entities.User;
import lombok.Getter;

@Getter
public class UserLogDTO {
    private User user;
    private String urlToLog;

    public UserLogDTO(User user) {
        this.user = user;
        urlToLog = "/logs/" + user.getLogin();
    }
}
