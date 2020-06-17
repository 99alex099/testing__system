package by.devincubator.services.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private String question;
    public boolean isCorrectly;
    private String literatureInfo;
}
