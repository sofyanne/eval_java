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

    @GetMapping("/ajout-admin")
    public String ajoutAdmin() {

        Administrateur nouvelAdmin = new Administrateur();
        nouvelAdmin.setLogin("Jean");
        nouvelAdmin.setPassword("root");
        nouvelAdmin.setDateContrat(new Date());

        administrateurDao.save(nouvelAdmin);

        return "OK";
    }

    @GetMapping("/utilisateur/{id}")
    @JsonView(AffichageUtilisateur.class)
    public Utilisateur utilisateur(@PathVariable int id) {

        return utilisateurDao.findById(id).orElse(null);
    }

    @GetMapping("/10-premier-utilisateur")
    @JsonView(AffichageUtilisateur.class)
    public List<Utilisateur> liste10PremierUtilisateur(){
        return utilisateurDao.trouve10premierUtilisateur();
    }

    @GetMapping("/n-premier-utilisateur/{nombreUtilisateur}")
    @JsonView(AffichageUtilisateur.class)
    public List<Utilisateur> listeNPremierUtilisateur(@PathVariable int nombreUtilisateur){
        return utilisateurDao.trouveNpremierUtilisateur(nombreUtilisateur);
    }


    @GetMapping("/utilisateur-by-login/{login}")
    @JsonView(AffichageUtilisateur.class)
    public Utilisateur utilisateur(@PathVariable String login) {

        return utilisateurDao.findByLogin(login).orElse(null);
    }

    @GetMapping("/liste-utilisateur")
    @JsonView(AffichageUtilisateur.class)
    public List<Utilisateur> utilisateurs() {

        System.out.println(utilisateurDao.maxIdUtilisateur());

        List<Utilisateur> listeUtilisateur = this.utilisateurDao.findAll();

        return listeUtilisateur;
    }

    @GetMapping("/somme-par-profession")
    public List<Object> sommeParProfession() {

        return this.utilisateurDao.sommeParProfession();
    }

    @PostMapping("/utilisateur")
    public String ajoutUtilisateur(@RequestBody Utilisateur utilisateur) {

        Competence developpeur = new Competence();
        developpeur.setId(1);

        utilisateur.getListeCompetence().add(developpeur);

        utilisateurDao.save(utilisateur);

        return "OK";
    }

    @DeleteMapping("/utilisateur/{id}")
    public String supprimeUtilisateur(@PathVariable int id) {

        utilisateurDao.deleteById(id);

        return "OK";
    }

}
