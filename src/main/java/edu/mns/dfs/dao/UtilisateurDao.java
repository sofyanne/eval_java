package edu.mns.dfs.dao;

import edu.mns.dfs.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur,Integer> {

    Optional<Utilisateur> findByLogin(String login);

    Optional<Utilisateur> findByLoginAndPassword(String login, String password);

    @Query("FROM Utilisateur U WHERE U.id <= 10")
    List<Utilisateur> trouve10premierUtilisateur();

    @Query("FROM Utilisateur U WHERE U.id <= :nombreUtilisateur")
    List<Utilisateur> trouveNpremierUtilisateur(@Param("nombreUtilisateur") int nombreUtilisateur);

    @Query("SELECT new Utilisateur(U.login) FROM Utilisateur U ")
    List<Utilisateur> trouveLoginsUtilisateur();

    @Query("SELECT max(U.id) FROM Utilisateur U")
    Integer maxIdUtilisateur();


    @Query("SELECT U.profession.nom , COUNT(*) FROM Utilisateur U GROUP BY U.profession.id ")
    List<Object> sommeParProfession();




}
