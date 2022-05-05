package edu.mns.dfs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.view.AffichageProfession;
import edu.mns.dfs.view.AffichageUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    public Utilisateur() {
    }

    public Utilisateur(String login) {
        this.login = login;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageUtilisateur.class, AffichageProfession.class})
    private Integer id;

    @JsonView({AffichageUtilisateur.class, AffichageProfession.class})
    private String login;

    @JsonView({AffichageUtilisateur.class, AffichageProfession.class})
    private String password;

    @ManyToOne
    @JsonView(AffichageUtilisateur.class)
    private Profession profession;

    @ManyToMany
    @JoinTable(
            name = "competence_utilisateur",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    @JsonView(AffichageUtilisateur.class)
    private List<Competence> listeCompetence = new ArrayList<>();
}
