
<h1> Api sea solutions</h1>

<span> Documentação completa no swagger </span>

<span > Link: https://sea-solutions-n71x.onrender.com/swagger-ui/index.html </span>

<span> ATENÇÃO: digite /v3/api-docs  na barra de pesquisa </span>



![](https://raw.githubusercontent.com/DaniloDeV90/assetsSea_challenge/main/Opera%20Instantâneo_2023-10-25_133515_sea-solutions-n71x.onrender.com.png?token=GHSAT0AAAAAACF7PSHYYFL53LBXKGV7MMOKZJZIRCA)

<hr>


<h2>Rota de setor</h2>

<h3> Retornar todos os setores </h3>

<span>GET   https://sea-solutions-n71x.onrender.com/setor </span> <br> <br>





<h3>Criar um setor  </h3>

<span> POST    https://sea-solutions-n71x.onrender.com/setor </span>
<br> <br>

<span> formato json: </span> <br> 
{ <br>
  "nomeSetor":  "string" <br>
} 


<h3> Editar  um setor </h3>

<span> PUT    https://sea-solutions-n71x.onrender.com/setor </span>

<span> formato json: </span> <br> 

{ <br>
  "nome": "string", <br>
  "novoNome": "string" <br>
}

<h3> Excluir  um setor </h3>

<span> DELETE    https://sea-solutions-n71x.onrender.com/setor </span>

<span> formato json: </span> <br> 
{ <br>
  "nomeSetor": "string" <br>
}

<hr/>

<h2>Rota de cargos</h2>



<h3> Criar um cargo </h3>

<span>  POST    https://sea-solutions-n71x.onrender.com/cargo </span>

<span> formato json: </span> <br> 
{ <br>
  "nomeSetor": "string" <br>
}

<h3> Editar um cargo </h3>



<span>  PUT    https://sea-solutions-n71x.onrender.com/cargo </span>


<span> formato json: </span> <br> 
{ <br>
  "nomeCargo": "string", <br>
  "nomeSetor": "string" <br>
}

<h3> Excluir um cargo </h3>



<span> DELETE    https://sea-solutions-n71x.onrender.com/cargo </span>


<span> formato json: </span> <br> 

{ <br>
  "setorNome": "string", <br>
  "nomeCargo": "string" <br>
}
<hr>
<h2> Rota trabalhador </h2>

<h3> criar trabalhador </h3>


<span>  POST    https://sea-solutions-n71x.onrender.com/trabalhador </span>

<span> formato json: </span> <br> 
{ <br>
  "nome": "string", <br>
  "cargo": "string", <br>
  "cpf": "string", <br>
  "nomeSetor": "string" <br>
}

