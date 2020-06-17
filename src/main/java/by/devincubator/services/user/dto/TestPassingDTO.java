package by.devincubator.services.user.dto;

import by.devincubator.entities.Question;
import by.devincubator.entities.Test;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TestPassingDTO {
    private static final int FIRST_QUESTION_INDEX = 0;

    private Test selectedTest;
    @Setter
    private int selectedQuestion = 0;
    @Setter
    private List<QuestionDTO> questionsDTO;

    public TestPassingDTO(Test selectedTest, List<Question> questionsDTO) {
        this.selectedTest = selectedTest;
        this.questionsDTO = new LinkedList<>();

        for (Question question : questionsDTO) {
            this.questionsDTO.add(new QuestionDTO(question));
        }
    }


}
