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
@Table(name = "literature")
public class Literature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "literatureId")
    private Integer literatureId;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;
    @OneToMany(mappedBy = "literature", fetch = FetchType.EAGER)
    private List<Link> links;

    @Override
    public String toString() {
        return description;
    }
}
