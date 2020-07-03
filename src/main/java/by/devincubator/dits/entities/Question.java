package by.devincubator.dits.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionId")
    private Integer questionId;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE/*, CascadeType.PERSIST*/})
    @JoinColumn(name = "testId", nullable = false)
    private Test test;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Literature> literature;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Statistic> statisticList;

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                ", test=" + test +
                '}';
    }
}
