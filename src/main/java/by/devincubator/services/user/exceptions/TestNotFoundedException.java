package by.devincubator.services.user.exceptions;

import by.devincubator.entities.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestNotFoundedException extends RuntimeException {
    private String testName;
    private Topic selectedTopic;
}
