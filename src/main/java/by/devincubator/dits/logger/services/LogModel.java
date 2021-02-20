package by.devincubator.dits.logger.services;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogModel {
    private long id;
    private String user;
    private String action;
    private Timestamp time = null;

    public LogModel(String user, String action) {
        this.user = user;
        this.action = action;
    }
}
