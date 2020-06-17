package by.devincubator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answerId")
    private Integer answerId;
    @Column(name = "description")
    private String description;
    @Column(name = "correct")
    private boolean isCorrect;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return isCorrect == answer.isCorrect &&
                answerId.equals(answer.answerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, isCorrect);
    }
}
