
const port = 8080; 
chargementDonnees(port);

//chargement des commandes
function exercice1(port) {

    fetch("http://localhost:" + port + "/liste-commande")
    .then(resultat => {

        return resultat.json();
    })
    .then(listeCommande => {
        const tableCommande = document.querySelector("#table-commande");
        const templateLigneCommande = document.querySelector("#template-ligne-commande");

        let chiffreAffaire = 0;
        let totalArticle = 0;

        listeCommande.forEach(commande => {

            const tr = templateLigneCommande.cloneNode(true);
            tr.style.display = "table-row";

            let nombreArticle = 0;
            let montantCommande = 0;

            commande.listeLigneCommande.forEach(ligne => {
                nombreArticle += ligne.quantite;
                montantCommande += ligne.quantite * ligne.article.prix;
            })

            tr.innerHTML = tr.innerHTML.replace("{{nom-client}}", commande.client.login);
            tr.innerHTML = tr.innerHTML.replace("{{nombre-article}}", nombreArticle);
            tr.innerHTML = tr.innerHTML.replace("{{montant-commande}}", montantCommande);

            tableCommande.appendChild(tr);

            chiffreAffaire += montantCommande;
            totalArticle += nombreArticle;
        });

        document.querySelector("#chiffre-affaire").innerHTML = chiffreAffaire + "€";

        document.querySelector("#total-article-vendu").innerHTML = totalArticle;

    })

}

function exercice2(port){

    fetch("http://localhost:" + port + "/compte-utilisateur")
        .then(resultat => resultat.json())
        .then(nombreUtilisateur => { 

            
            const elementNombreUtilisateur = document.querySelector("#nombre-utilisateur");

            elementNombreUtilisateur.innerHTML = nombreUtilisateur;
        });
    
}


//chargement du nombre d'employe
function exercice3(port) {

    fetch("http://localhost:" + port + "/compte-administrateur")
        .then(resultat => resultat.json())
        .then(nombreAdministrateur => {


            document.querySelector("#nombre-administrateur").innerHTML = nombreAdministrateur;
        });

}

//chargement des employe
function exercice4(port) {

    fetch("http://localhost:" + port + "/liste-employe")
        .then(resultat => resultat.json())
        .then(listeEmploye => {

            const blocEmployes = document.querySelector("#bloc-employe");
            const templateEmploye = document.querySelector("#template-employe");
            const templateModal = document.querySelector("#template-modal");

            listeEmploye.forEach(employe => {

                const div = templateEmploye.cloneNode(true);
                div.style.display = "block";

                div.innerHTML = div.innerHTML.replace("{{nom-employe}}", employe.login);
                div.innerHTML = div.innerHTML.replace("{{administrateur}}", employe.administrateur ? "Administrateur":"Employe");

                blocEmployes.appendChild(div);

                const modal = templateModal.cloneNode(true);

                modal.id = "modal-" + employe.id;

                div.appendChild(modal);
                
                div.addEventListener("click", e => {
                    modal.style.display = "block";

                    fetch("http://localhost:" + port + "/employe/" + employe.id)
                        .then(resultat => resultat.json())
                        .then(employe => {

                            modal.innerHTML = modal.innerHTML.replace("{{nom-employe}}", employe.login);
                            
                            const ul = modal.querySelector(".liste-article-gerer");

                            employe.listeArticleAgerer.forEach(article => {
                                const li = document.createElement("li")
                                li.innerHTML = article.nom;

                                ul.appendChild(li);
                            })

                            const close = modal.querySelector(".btn-action-close");

                            close.addEventListener("click", e => {
                                modal.style.display = "none";
                                e.stopPropagation();
                            });

                        });
                });

               
            });
        });



    
    
    
}


function chargementDonnees() {
    exercice1(port);
    exercice2(port);
    exercice3(port);
    exercice4(port);
}



function ajoutArticle(article) {

    

}