

function lerDados ()
{
let strDados = localStorage.getItem('avaliacao19')
let objDados = {};
//Se tiver dados no storage
if (strDados)
{
objDados = JSON.parse (strDados);
}
//Se não tiver dados no storage
else
{
objDados = { usuarios:[
    {
    nota: 2
    },
    {
    nota: 3
    },
    {
    nota: 4
    },
    {
    nota: 4
    },
    {
    nota: 1
    },
     {
    nota: 3
    },
    {
    nota: 5
    },
    {
    nota: 1
    }
    ]
    }   
}
return objDados;
}

function salvarDados(dados)
{
localStorage.setItem('avaliacao19',JSON.stringify(dados));
}

//Função pra analisar qual nota foi escolhida pelo usuario
function check()
{
let x;
let nota1 = document.getElementById("nota1").checked;
let nota2 = document.getElementById("nota2").checked;
let nota3 = document.getElementById("nota3").checked;
let nota4 = document.getElementById("nota4").checked;
let nota5 = document.getElementById("nota5").checked;
if( nota1 == true)
{
x = document.getElementById("nota1").value  
}
else if (nota2 == true)
{
  x = document.getElementById("nota2").value  

}
else if (nota3 == true)
{
  x = document.getElementById("nota3").value  

}
else if (nota4 == true)
{
  x = document.getElementById("nota4").value  

}
else if (nota5 == true)
{
  x = document.getElementById("nota5").value  

}
else
{
let tela = document.getElementById('tela');
tela.innerHtml = "Nao foi possivel analisar sua nota";
}
return parseInt(x);
}

//Armazenando a nota do usuario no local storage (OPERAÇÃO PRINCIPAL)
function incluirNota()
{
//Ler os dados do LocalStorage
let objDados = lerDados();

//Incluir Nota
let strNota = check();
let novaNota = {
nota: strNota
}
objDados.usuarios.push(novaNota);
// Salvar os dados no localStorage novamente
salvarDados (objDados);

//Mostrar na tela com os dados atualizados
imprimirDados();
}


function mediaNota()
{
let quantidade = 0;
let objDados = lerDados();
let notas = 0;
//Pegando as notas dos usuarios e fazendo a média.
for (i = 0; i < objDados.usuarios.length; i++)
{
notas += objDados.usuarios[i].nota;
quantidade++;
}
notas = notas/quantidade;
return notas.toFixed(1);
}

function imprimirDados ()
{
let notas = mediaNota();
document.getElementById("notaExibida").innerHTML = notas;
}

//Botão de Salvar a nota
document.getElementById ('salvarNota').addEventListener ('click', incluirNota);

