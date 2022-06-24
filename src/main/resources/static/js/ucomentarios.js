$(document).ready(function() {
    cargarComent();
});


async function cargarComent(){

    const request = await fetch('api/comentarios', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const coment2 = await request.json();
    console.log(coment2);

    let listadoComentHtml= '';

    for(let comentario of coment2){
        let comentHtml = '<tr><th><h2 class="small card-title">'+comentario.id_usuario+'</h2></th><th><div class="small text-muted">'+comentario.comentarios+'</div></th></tr>';

        listadoComentHtml+=comentHtml;
    }

    document.querySelector('#coment2 tbody').outerHTML = listadoComentHtml;
}

