var blogeo = document.getElementById('sigin');
blogeo.addEventListener('click', function () {
    var e = document.getElementById('email').value);
var p = document.getElementById('password').value);
constant parametros = new URLSearchParams();
parametros.append('ParaEmail', e);
parametros.append('ParaPass', p);
axios.get('http://localhost/Adios')
    .then(function (response) {
        console.log(response)
        console.log('contenido: ' + response.data)
        console.log('estatus: ' + response.status)
        document.getElementById('titulo').innerHTML = response.data
    })
    .catch(function (error) {
        console.log(error)
    })
})