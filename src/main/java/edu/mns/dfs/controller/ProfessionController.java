package edu.mns.dfs.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.ProfessionDao;
import edu.mns.dfs.model.Profession;
import edu.mns.dfs.view.AffichageProfession;
import edu.mns.dfs.view.AffichageUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProfessionController {

    ProfessionDao professionDao;

    @Autowired
    public ProfessionController(ProfessionDao professionDao){
        System.out.println(professionDao);
        this.professionDao = professionDao;
    }

    @GetMapping("/profession/{id}")
    @JsonView(AffichageProfession.class)
    public Profession profession(@PathVariable int id) {

        return professionDao.findById(id).orElse(null);
    }

    @GetMapping("/liste-profession")
    @JsonView(AffichageProfession.class)
    public List<Profession> professions() {

        List<Profession> listeProfession = this.professionDao.findAll();

        return listeProfession;
    }

    @PostMapping("/profession")
    public String ajoutProfession(@RequestBody Profession profession) {

        professionDao.save(profession);

        return "OK";
    }

    @DeleteMapping("/profession/{id}")
    public String supprimeProfession(@PathVariable int id) {

        professionDao.deleteById(id);

        return "OK";
    }

}
