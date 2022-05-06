package edu.mns.dfs.controller;

import edu.mns.dfs.dao.UtilisateurDao;
import edu.mns.dfs.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {

    UtilisateurDao utilisateurDao;

    @Autowired
    public UtilisateurController(
            UtilisateurDao utilisateurDao){

        this.utilisateurDao = utilisateurDao;
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
