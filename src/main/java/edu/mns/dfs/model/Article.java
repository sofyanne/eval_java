package edu.mns.dfs.model;


import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.view.AffichageArticle;
import edu.mns.dfs.view.AffichageCommande;
import edu.mns.dfs.view.AffichageUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(AffichageArticle.class)
    private Integer Id;

    @JsonView({AffichageArticle.class, AffichageUtilisateur.class})
    private String nom;

    @JsonView({AffichageArticle.class, AffichageCommande.class})
    private float prix;

    @ManyToOne
    private Employe gestionnaire;

    @ManyToMany
    private List<Propriete> listeCaracteristique;
}
