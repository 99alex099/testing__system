package by.devincubator.dits.services.general.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Deprecated
public class UserAnswersDTO {
    private List<Integer> userAnswers;
}
