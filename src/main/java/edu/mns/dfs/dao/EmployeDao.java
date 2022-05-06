package edu.mns.dfs.dao;

import edu.mns.dfs.model.Employe;
import edu.mns.dfs.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeDao extends JpaRepository<Employe, Integer> {

    @Query("FROM Employe E WHERE E.administrateur = true")
    List<Employe> findAdministrateur();
}
