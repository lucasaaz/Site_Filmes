let dadosHTML2 = ' ';
const mostratilmes = (data) => {
  let dadosFilmes = JSON.parse(data.target.response)
  console.log(dadosFilmes);
  localStorage.setItem('db_filmes', data.target.response)
  for (let i = 0; i < 20; i++) {
    let tilia = dadosFilmes.results[i];
    dadosHTML2 += `<div class="col-3 col-md-6 col-sm-12 col-lg-3"><div class="card-group" id="lista_filmes" style="padding-top:30px; >
<div class="card" style="width: 18rem;">
<img src="https://image.tmdb.org/t/p/original/${tilia.poster_path}" class="card-img-top"alt="">
<div class="card-body">
<h5 class="card-title">${tilia.title}</h5>
<a href="Movie0.html?id=${tilia.id}" class="btn btn-dark">Acesse</a>
</div>
</div>
</div>
</div>`;
  }
  document.getElementById('lista_filmes_destaque').innerHTML = dadosHTML2
}

//HTML Filmes
function exibirFilmesDestaque() {
  let xhr = new XMLHttpRequest();
  let url = "https://api.themoviedb.org/3/movie/popular?api_key=16fbb8062ed98d2f19ed95f35348c8e9&language=pt-BR&page=" + parseInt(Math.random() * 20 + 1)
  xhr.onload = mostratilmes;
  xhr.open('GET', url, true);
  xhr.send();
}
$(document).ready(function() {
  exibirFilmesDestaque();
});