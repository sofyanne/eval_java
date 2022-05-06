package edu.mns.dfs.model;


import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.view.AffichageMoyenPaiement;
import edu.mns.dfs.view.AffichageUtilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class MoyenPaiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({AffichageUtilisateur.class, AffichageMoyenPaiement.class})
    private Integer id;
    @JsonView({AffichageUtilisateur.class, AffichageMoyenPaiement.class})
    private String nom;
}
