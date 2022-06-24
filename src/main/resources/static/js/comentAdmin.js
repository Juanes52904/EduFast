// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarComent();
    actualizarEmailDelUsuario();
});

function actualizarEmailDelUsuario(){
    document.getElementById('txt-email-usuario').outerHTML=localStorage.email;
}


async function cargarComent(){

    const request = await fetch('api/comentarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const coment = await request.json();
    console.log(coment);

    let listadoComentHtml= '';

    for(let comentario of coment){
        let btnElm ='<a href=\"#\" onclick="eliminarComentario('+comentario.id+')" class=\"btn btn-danger btn-circle btn-sm\"><i class=\"fas fa-trash\"></i></a>';

        let comentHtml = '<tr><td>'+comentario.id+'</td><td>'+comentario.id_usuario+'</td><td>'+comentario.comentarios+'</td><td>'+btnElm+'</td></tr>';

        listadoComentHtml+=comentHtml;
    }

    document.querySelector('#coment1 tbody').outerHTML = listadoComentHtml;
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}



async function eliminarComentario(id) {

    if (!confirm('¿Desea eliminar el Comentario?')){
        return;
    }
    const request = await fetch('api/comentario/' + id, {
        method: 'DELETE',
        headers: getHeaders()
    });

    location.reload()
}
