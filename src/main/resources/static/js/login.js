
$(document).ready(function() {
// on ready
});




async function iniciarSesion() {
    let datos = {};
    datos.email= document.getElementById('txtEmail').value;
    datos.password= document.getElementById('txtPassword').value;


    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const respuesta = await request.text();
    if (respuesta != "fail"){
        localStorage.token = respuesta;
        localStorage.email = datos.email;
        if(localStorage.email != "juanesorozco46@gmail.com"){
            window.location.href = 'blogp.html'
        }else{
            window.location.href = 'usuarios.html'
        }
    }else {
        alert("Correo y/o Contraseña incorrectos")
    }
}