package edu.mns.dfs.dao;

import edu.mns.dfs.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommandeDao extends JpaRepository<Commande, Integer> {
}
