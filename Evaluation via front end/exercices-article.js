const port = 8080; 

const submit = document
    .querySelector("#submit")
    .addEventListener("click",() => {

        const article = {
            nom: document.querySelector("#input-nom").value,
            prix: document.querySelector("#input-prix").value
        };

        fetch("http://localhost:" + port + "/article",
            {
                method: "POST",
                headers: {
                    'Accept': 'application/json, text/plain, */*',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(article)
            }
        )
        .then(r => alert("article ajouté"));
    });
