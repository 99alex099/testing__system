package by.devincubator.services.user.exceptions;

import by.devincubator.services.user.dto.TestPassingDTO;
import lombok.Data;

@Data
public class TestNotHavingQuestions extends RuntimeException {
    private TestPassingDTO testPassingDTO;
    public TestNotHavingQuestions(TestPassingDTO testPassingDTO) {
        super("test doesn't have questions without answers");
        this.testPassingDTO = testPassingDTO;
    }
}
