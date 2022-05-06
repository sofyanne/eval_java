package edu.mns.dfs.controller;


import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.AdministrateurDao;
import edu.mns.dfs.dao.EmployeDao;
import edu.mns.dfs.model.Administrateur;
import edu.mns.dfs.model.Employe;
import edu.mns.dfs.model.Profession;
import edu.mns.dfs.model.Utilisateur;
import edu.mns.dfs.view.AffichageAdministrateur;
import edu.mns.dfs.view.AffichageEmploye;

import edu.mns.dfs.view.AffichageUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeController {
    EmployeDao employeDao;
    AdministrateurDao administrateurDao;

    @Autowired
    public EmployeController(EmployeDao employeDao, AdministrateurDao administrateurDao) {

        this.employeDao = employeDao;
        this.administrateurDao = administrateurDao;
    }

    @GetMapping("/employe/{id}")
    @JsonView(AffichageEmploye.class)
    public Employe employe(@PathVariable int id) {

        return employeDao.findById(id).orElse(null);
    }

    @GetMapping("/liste-employe")
    @JsonView(AffichageEmploye.class)
    public List<Employe> listeEmploye() {


        List<Employe> listeEmploye = this.employeDao.findAll();

        return listeEmploye;
    }

    @GetMapping("/compte-administrateur")
    @JsonView(AffichageAdministrateur.class)
    public Integer compteAdministrateur() {

        List<Administrateur> listeUtilisateur = this.administrateurDao.findAll();

        return listeUtilisateur.size();
    }
}
