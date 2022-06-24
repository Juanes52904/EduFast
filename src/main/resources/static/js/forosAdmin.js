// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarForos();
    actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario(){
    document.getElementById('txt-email-usuario').outerHTML=localStorage.email;
}


async function cargarForos(){

    const request = await fetch('api/foros', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const foros = await request.json();
    console.log(foros);

    let listadoForoHtml= '';

    for(let foro of foros){
        let btnElm ='<a href=\"#\" onclick="eliminarForo('+foro.id+')" class=\"btn btn-danger btn-circle btn-sm\"><i class=\"fas fa-trash\"></i></a>';

        let forumHtml = '<tr><td>'+foro.id+'</td><td>'+foro.titulo+'</td><td>'+foro.subtitulo+'</td><td>'+foro.id_usuario+'</td><td>'+btnElm+'</td></tr>';

        listadoForoHtml+=forumHtml;
    }

    document.querySelector('#foros1 tbody').outerHTML = listadoForoHtml;
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}



async function eliminarForo(id) {

    if (!confirm('¿Desea eliminar el Foro?')){
        return;
    }
    const request = await fetch('api/foros/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload()
}
