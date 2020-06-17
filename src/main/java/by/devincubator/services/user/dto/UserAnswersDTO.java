package by.devincubator.services.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserAnswersDTO {
    private List<Integer> userAnswers;
}
