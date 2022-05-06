package edu.mns.dfs;

import edu.mns.dfs.model.Article;
import edu.mns.dfs.model.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DfsApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@BeforeEach
	private void init (){

		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	void creationArticle_nomNonNull() {

		Article article = new Article();
		article.setNom("Sofyanne");
		assertNotNull(article.getNom());

	}

	@Test
	void appelApiGetListeUtilisateur_obtientCode200() throws Exception {

		mvc.perform(get("/liste-employe")).andExpect(status().isOk());

	}

	@Test
	void appelApiGetListeUtilisateur_contientJSON() throws Exception {

		mvc.perform(get("/liste-employe").contentType(MediaType.APPLICATION_JSON));

	}


}
