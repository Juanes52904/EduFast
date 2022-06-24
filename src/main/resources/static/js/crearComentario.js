$(document).ready(function() {
    // on ready
});

async function registrarComentario() {
    let datos = {};
    datos.id_usuario= document.getElementById('txtIdUsuario').value;
    datos.comentarios= document.getElementById('txtComentario').value;


    const request = await fetch('api/comentarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("¡Has publicado tu comentario correctamente!");
    window.location.href = 'blog.html'
}