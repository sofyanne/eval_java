package edu.mns.dfs.model;

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
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageUtilisateur.class, AffichageProfession.class})
    private Integer id;
    @JsonView({AffichageUtilisateur.class, AffichageProfession.class})
    private String nom;

    @OneToMany(mappedBy = "profession")
    @JsonView(AffichageProfession.class)
    private List<Utilisateur> listeUtilisateur = new ArrayList<>();

}
