package lesson59.hiber;

import jakarta.persistence.ManyToMany;
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
import java.util.Set;

@Entity
@Table(name = "social_networks")
@Setter
@Getter
@NoArgsConstructor
public class SocialNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "website_url")
    private String websiteUrl;

    @ManyToMany(mappedBy = "socialNetworks")
    private Set<User> users;

    public SocialNetwork(String name, String websiteUrl) {
        this.name = name;
        this.websiteUrl = websiteUrl;
    }


}
