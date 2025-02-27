package lesson59.hiber;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_social_network",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "social_network_id")
    )
    private Set<SocialNetwork> socialNetworks = new HashSet<>();


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // Метод для добавления социальной сети
    public void addSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetworks.add(socialNetwork);
        socialNetwork.getUsers().add(this);
    }

    // Метод для удаления социальной сети
    public void removeSocialNetwork(SocialNetwork socialNetwork) {
        this.socialNetworks.remove(socialNetwork);
        socialNetwork.getUsers().remove(this);
    }
}