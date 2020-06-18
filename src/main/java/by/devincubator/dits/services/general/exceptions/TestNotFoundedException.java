package by.devincubator.dits.services.general.exceptions;

import by.devincubator.dits.entities.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestNotFoundedException extends RuntimeException {
    private String testName;
    private Topic selectedTopic;
}
