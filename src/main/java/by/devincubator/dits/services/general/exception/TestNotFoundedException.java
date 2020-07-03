package by.devincubator.dits.services.general.exception;

import by.devincubator.dits.entities.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestNotFoundedException extends RuntimeException {
    private String testName;
    private Topic selectedTopic;
}
