
let dadosHTML8 = ' ';
document.body.onload = () => {
  let page = 1;
  searching();
  function searching() {

    const SEARCH_URL = "//api.themoviedb.org/3/search/movie?api_key=16fbb8062ed98d2f19ed95f35348c8e9&language=pt-BR&include_adult=true&query=" + localStorage.getItem('valueText') + "&page=" + page;
    /*let xhr = new XMLHttpRequest();
    xhr.onload = mostra;
    xhr.open('GET', SEARCH_URL, true);
    xhr.send();*/
    createJSON(SEARCH_URL);
  };
  function createJSON(SEARCH_URL) {
    fetch(SEARCH_URL)
      .then((res) => res.json())
      .then((search) => {
        localStorage.setItem('Jsonzim', JSON.stringify(search));
        console.log(search);
        //mostra();

        showSearch(search);
        //mostra();
      })
      .catch(function(error) {
        console.log(
          "There has been a problem with your fetch operation: " + error.message
        );
      });
  }


  let count = 0;
  /*
                              const mostra = (data) => {
                                  let dadosFilmes = JSON.parse(data.target.response)
                                  console.log(dadosFilmes);
                                  localStorage.setItem('dbb_filmes', data.target.response)
                                  for (let i = 0; i < 8; i++) {
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
                                  document.getElementById('searchList').innerHTML = dadosHTML2
                              }*/
  function showSearch(search) {
    for (let y = 0; y < search.results.length - 1; y++) {
      let filme = search.results[y];
      console.log("search");
      dadosHTML8 += `
                                    <div class="cardSearch mb-3">
                                        <div class="g-0 row searchCardFilmHover">
                                           
                                            <div class="col-md-2 card-search-img">
                                            <img
                                                src="https://image.tmdb.org/t/p/w500/${filme.poster_path}"
                                                class="img-fluid rounded-start"
                                                alt="..."
                                                style="max-width: 10.5em"
                                            />
                                            </div>
                                            <div class="col-md-10">
                                            <div class="card-body">
                                                <h5 class="card-title">${filme.title}</h5>
                                                <h6 class="info1">${filme.release_date} - Media da Critica:${filme.vote_average}</h6>
                                                <p class="card-text">
                                                ${filme.overview}
                                                </p>
                                                
                                            </div>
                                            </div>
                                           
                                        </div>
                                        </div>
                                    
        
                                        `;
    } console.log(dadosHTML8);
    if (dadosHTML8 != null) {
      document.getElementById("searchList").innerHTML = dadosHTML8;
    }
  }
}