package edu.mns.dfs.controller;


import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.EmployeDao;
import edu.mns.dfs.model.Employe;

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

    @Autowired
    public EmployeController(EmployeDao employeDao) {

        this.employeDao = employeDao;
    }

    @GetMapping("/employe/{id}")
    @JsonView(AffichageUtilisateur.class)
    public Employe employe(@PathVariable int id) {

        return employeDao.findById(id).orElse(null);
    }

    @GetMapping("/liste-employe")
    @JsonView(AffichageUtilisateur.class)
    public List<Employe> listeEmploye() {


        List<Employe> listeEmploye = this.employeDao.findAll();

        return listeEmploye;
    }

    @GetMapping("/compte-administrateur")
    @JsonView({AffichageUtilisateur.class})
    public Integer compteAdministrateur() {

        List<Employe> listeUtilisateur = this.employeDao.findAdministrateur();
        return listeUtilisateur.size();
    }
}
