Objetivo
Criar uma API Rest de um cadastro de Pessoas, utilizando Spring Boot e Java
Requisitos:
•         Possuir ao menos os endpoints: GET(Buscar uma única Pessoa), GET (Busca paginada opção de filtro para retornar várias pessoas), POST, PUT, DELETE(ok)
•         O cadastro de pessoa deve ter os campos: Id, Nome, CPF, Data de nascimento.(ok)
•         A pessoa deve possuir uma lista de contatos (relacionamento um para muitos) com os campos: Id, Nome, Telefone e Email.(ok)
•         Os dados devem ser persistidos utilizando um banco de dados relacional.(ok)
Validações:
•         Todos os campos são obrigatórios, tanto da pessoa como do contato(ok)
•         A Pessoa deve possuir ao menos um contato(ok)
•         O CPF deve ser um CPF válido(ok)
•         A Data de nascimento não pode ser uma data futura(ok)
•         Validar sintaxe do email do contato(ok)
Requisitos técnicos:
•         Deverão ser criados testes unitários(X)
•         Publicar o código em repositório público(ok)
É opcional e será um diferencial:
•         Implementar o front-end para consumir a API.(X)
o    Desejável que seja em ReactJS ou Angular
•         Publicar a aplicação na internet utilizando algum provedor, para que possa ser acessado sem necessidade de rodar o projeto local(X)
