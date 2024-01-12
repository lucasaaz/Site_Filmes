// declara um conjunto inicial de contatos
var db_comentariosf14_inicial = {
    "data": [
        {            
            "nome": "admin",            
            "telefone": "muito bom",            
        },        
    ]
}

// Caso os dados já estejam no Local Storage, caso contrário, carrega os dados iniciais
var db = JSON.parse(localStorage.getItem('db_comentariosf14'));
if (!db) {
    db = db_comentariosf14_inicial
};

// Exibe mensagem em um elemento de ID msg
function displayMessage(msg) {
    $('#msg').html('<div class="alert alert-warning">' + msg + '</div>');
}

function insertContato(comentarios) {
    // Calcula novo Id a partir do último código existente no array (PODE GERAR ERRO SE A BASE ESTIVER VAZIA)
    
    let novoContato = {        
        "nome": comentarios.nome,
        "telefone": comentarios.telefone,
    };

    // Insere o novo objeto no array
    db.data.push(novoContato);
    displayMessage("Comentario inserido com sucesso");

    // Atualiza os dados no Local Storage
    localStorage.setItem('db_comentariosf14', JSON.stringify(db));
}
