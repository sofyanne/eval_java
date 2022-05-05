INSERT INTO profession (nom) VALUES ("developpeur"),("comptable"),("pdg");

INSERT INTO utilisateur (login,password,profession_id)
VALUES ("franck","root",3),("admin","root",1), ("user2","root",1), ("user3","root",1), ("user4","root",1), ("user5","root",1), ("user6","root",1), ("user7","root",1), ("user8","root",1), ("user9","root",1), ("user10","root",1), ("user11","root",1), ("user12","root",1), ("user13","root",1), ("user14","root",1), ("user15","root",1);

INSERT INTO competence (nom) VALUES ("JAVA"),("PHP"),("Excel");

INSERT INTO competence_utilisateur (utilisateur_id, competence_id) VALUES (1,1),(1,2),(2,1),(2,3);

