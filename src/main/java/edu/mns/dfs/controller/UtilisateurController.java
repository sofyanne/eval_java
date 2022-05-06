package edu.mns.dfs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.AdministrateurDao;
import edu.mns.dfs.dao.UtilisateurDao;
import edu.mns.dfs.model.Administrateur;
import edu.mns.dfs.model.Competence;
import edu.mns.dfs.model.Utilisateur;
import edu.mns.dfs.view.AffichageUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {

    UtilisateurDao utilisateurDao;
    AdministrateurDao administrateurDao;

    @Autowired
    public UtilisateurController(
            UtilisateurDao utilisateurDao,
            AdministrateurDao administrateurDao){

        this.utilisateurDao = utilisateurDao;
        this.administrateurDao = administrateurDao;
    }


    @GetMapping("/compte-utilisateur")
    public Integer compteUtilisateur() {

        List<Utilisateur> listeUtilisateur =  this.utilisateurDao.findAll();
        return listeUtilisateur.size();
    }


    @DeleteMapping("/utilisateur/{id}")
    public String supprimeUtilisateur(@PathVariable int id) {

        utilisateurDao.deleteById(id);

        return "Utilisateur supprimé !";
    }

}
