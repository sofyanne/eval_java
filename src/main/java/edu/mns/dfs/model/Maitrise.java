package edu.mns.dfs.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@IdClass(CleMaitrise.class)
@Getter
@Setter
public class Maitrise {

    @Id
    private Integer utilisateurId;
    @Id
    private Integer competenceId;

    private String niveau;

    @ManyToOne
    @MapsId("utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("competence_id")
    private Competence competence;

}
