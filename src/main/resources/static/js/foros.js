// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarForos();
    actualizarEmail();
});

function actualizarEmail(){
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
        let forumHtml = '<tr><td><h2 class="card-title">'+foro.titulo+'</h2></td><td><div class="small text-muted">'+foro.subtitulo+'</div></td><td><p class="card-text">'+foro.descripcion+'</p></td><td><div class="small text-muted">'+foro.id_usuario+'</div></td><td><a class="btn btn-primary" href="blog.html">Ver más →</a></td></tr>';

        listadoForoHtml+=forumHtml;
    }

    document.querySelector('#foros tbody').outerHTML = listadoForoHtml;
}
