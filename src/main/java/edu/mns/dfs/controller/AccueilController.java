package edu.mns.dfs.controller;

import edu.mns.dfs.dao.UtilisateurDao;
import edu.mns.dfs.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AccueilController {


    @GetMapping("/")
    public String accueil() {
        return "Le serveur marche, mais ici y'a rien à voir";
    }

}
