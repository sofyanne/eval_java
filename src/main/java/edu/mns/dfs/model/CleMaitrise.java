package edu.mns.dfs.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CleMaitrise implements Serializable {

    @Column(name = "utilisateur_id")
    Integer utilisateurId;

    @Column(name = "competence_id")
    Integer competenceId;

}
