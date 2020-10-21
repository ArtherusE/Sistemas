var blogeo = document.getElementById("signin");
blogeo.addEventListener("click", function() {
    var pass = document.getElementById("password").value;
    var email = document.getElementById("email").value;
    const parametros = new URLSearchParams();
    parametros.append("PrmEmail", email);
    parametros.append("PrmPassword", pass);
   axios.post('http://localhost/adios' + parametros)
    .then(function(response) {
        console.log(response);
        console.log("contenido: " + response.data);
        console.log("status: " + response.status);
        document.getElementById("titulo").innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    })
})
/*axios.post("http://127.0.0.1:5500")
    .then(function(response) {
        console.log(response);
        console.log("contenido: " + response.data);
        console.log("status: " + response.status);
        document.getElementById("titulo").innerHTML = response.data;
    })
    .catch(function(error) {
        console.log(error)
    })
})*/