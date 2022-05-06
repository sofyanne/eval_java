package edu.mns.dfs.dao;

import edu.mns.dfs.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeDao extends JpaRepository<Employe, Integer> {
}
