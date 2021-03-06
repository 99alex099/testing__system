package by.devincubator.dits.services.general.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserStatisticDTO {
    private String question;
    private double correctAnswersPercent;
    private String topic;
}
