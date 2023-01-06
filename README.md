Orientações para executar o projeto:

Usar o banco de dados: MySQL
No MySQL criar o scheema: vendas

Garantir que seu MySql tenha username e password: root

Rotas do cliente

/cliente/criar  - Pede os dados do cliente no body

/cliente/buscaPorId/{id} - Pede ID no path

/cliente/buscatodos 

/cliente/atualizar/{id} - Atualiza cliente, pede os dados novos no body

/cliente/apagaCliente/{id} - Id no path

___________________________________________________________________________

Rotas do produto

/produto/criar - Dados no body

/produto/buscaPorId/{id} - Id no path

/produto/buscatodos

/produto/atualizar/{id} - Id no path e dados no body

/produto/apagaProduto/{id} - Id no path


Rotas de venda

/vendas/vender/{produtoId}/{clienteId} - Vincula o produto no usuario pegando os ids no path

/vendas/relatorio - Mostra tudo que ja foi vendido
