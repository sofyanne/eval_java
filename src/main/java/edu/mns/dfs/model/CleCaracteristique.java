package edu.mns.dfs.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CleCaracteristique implements Serializable{



        @Column(name = "article_id")
        Integer articleId;

        @Column(name = "propriete_id")
        Integer proprieteId;

}
