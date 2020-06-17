package by.devincubator.services.user.dto;

import by.devincubator.entities.Answer;
import by.devincubator.entities.Question;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class QuestionDTO {

    private Question question;
    private List<Answer> userAnswers;

    public QuestionDTO(Question question) {
        this.question = question;
    }
    @Override
    public String toString() {
        return "QuestionDTO{" +
                "question=" + question +
                ", userAnswers=" + userAnswers +
                '}';
    }
}
