package edu.mns.dfs.dao;

import edu.mns.dfs.model.CleMaitrise;
import edu.mns.dfs.model.Maitrise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaitriseDao extends JpaRepository<Maitrise, CleMaitrise> {
}
