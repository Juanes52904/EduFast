$(document).ready(function() {
    // on ready
});




async function registrarForos() {
    let datos = {};
    datos.titulo= document.getElementById('txtTitulo').value;
    datos.subtitulo= document.getElementById('txtSubtitulo').value;
    datos.descripcion= document.getElementById('txtDescripcion').value;
    datos.id_usuario= document.getElementById('txtUsuario').value;


    const request = await fetch('api/foros', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("¡Has publicado tu foro correctamente!");
    window.location.href = 'blogp.html'
}