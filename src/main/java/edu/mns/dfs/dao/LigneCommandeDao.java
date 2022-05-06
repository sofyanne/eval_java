package edu.mns.dfs.dao;

import edu.mns.dfs.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeDao extends JpaRepository<LigneCommande, Integer> {

}
