package edu.mns.dfs.controller;


import com.fasterxml.jackson.annotation.JsonView;
import edu.mns.dfs.dao.ArticleDao;
import edu.mns.dfs.dao.CommandeDao;
import edu.mns.dfs.model.Article;
import edu.mns.dfs.model.Commande;
import edu.mns.dfs.view.AffichageCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin
public class CommandeController {

    CommandeDao commandeDao;
    ArticleDao articleDao;

    @Autowired
    public CommandeController(CommandeDao commandeDao, ArticleDao articleDao) {
        this.commandeDao = commandeDao;
        this.articleDao = articleDao;
    }

    @GetMapping("/liste-commande")
    @JsonView(AffichageCommande.class)
    public List<Commande> commandes() {
        List<Commande> listeCommandes = this.commandeDao.findAll();
        return listeCommandes;
    }

    @PostMapping("/article")
    @JsonView(AffichageCommande.class)
    public String ajouterArticle() {
        Article nouvelArticle = new Article();
        nouvelArticle.setNom("Jean");
        nouvelArticle.setPrix(1);

        articleDao.save(nouvelArticle);

        return "OK";
    }

}
