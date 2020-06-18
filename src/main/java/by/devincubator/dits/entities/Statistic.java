package by.devincubator.dits.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statisticId")
    private Integer statisticId;
    @Column(name = "date")
    private Date date;
    @Column(name = "correct")
    private boolean isCorrect;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Statistic{" +
                "statisticId=" + statisticId +
                ", date=" + date +
                ", isCorrect=" + isCorrect +
                ", question=" + question +
                ", user=" + user +
                '}';
    }
}
