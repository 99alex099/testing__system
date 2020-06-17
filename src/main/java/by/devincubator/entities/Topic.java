package by.devincubator.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicId")
    private Integer topicId;
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    private List<Test> tests;

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
