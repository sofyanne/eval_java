package edu.mns.dfs.dao;

import edu.mns.dfs.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurDao extends JpaRepository<Administrateur, Integer> {
}
