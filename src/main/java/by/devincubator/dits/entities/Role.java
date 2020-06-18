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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Integer id;
    @Column(name = "roleName")
    private String roleName;

    @ManyToMany
    @JoinTable(name="roles_of_users",
            joinColumns = @JoinColumn(name="roleId"),
            inverseJoinColumns = @JoinColumn(name="userId")
    )
    private List<User> userList;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
