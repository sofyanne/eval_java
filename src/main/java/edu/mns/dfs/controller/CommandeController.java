package edu.mns.dfs.controller;


import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.CommandeDao;
import edu.mns.dfs.model.Commande;
import edu.mns.dfs.view.AffichageCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CommandeController {

    CommandeDao commandeDao;

    @Autowired
    public CommandeController(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @GetMapping("/liste-commande")
    @JsonView(AffichageCommande.class)
    public List<Commande> commandes() {
        List<Commande> listeCommandes = this.commandeDao.findAll();
        return listeCommandes;
    }
}
