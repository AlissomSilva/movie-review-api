# Movie Review API

## Descrição

Esta API REST permite gerenciar filmes, incluindo funcionalidades para criar, atualizar, listar, deletar e avaliar filmes. A aplicação está conectada a um banco de dados H2 para armazenamento das informações dos filmes.

## Rotas

### Criar 

- **Endpoint:** `POST /movies`
- **Descrição:** Cria um novo filme.
- **Corpo da Requisição:**
  ```json
  {
    "titulo": "Título do Filme",
    "descricao": "Descrição do Filme",
    "diretor": "Nome do Diretor",
    "genero": "Gênero do Filme",
    "rating": 8.5
  }
  
- **Respostas:**
  201 Created - O filme foi criado com sucesso.
  400 Bad Request - Se algum campo obrigatório estiver faltando ou inválido. Mensagens de erro podem incluir:

"Título não pode ser vazio" - Se o campo titulo estiver vazio.
"Descrição não pode ser vazio" - Se o campo descricao estiver vazio.
"Diretor não pode ser vazio" - Se o campo diretor estiver vazio.
"Gênero não pode ser vazio" - Se o campo genero estiver vazio.

### Listar 

- **Endpoint:** GET /movies
- **Descrição:** Lista todos os filmes no banco de dados.
- **Respostas:**
  200 OK - Lista dos filmes em formato JSON.

### Obter um Filme por ID

- **Endpoint:** GET /movies/{id}
- **Descrição:** Obtém os detalhes de um filme específico pelo ID.
- **Respostas:**
  200 OK - Detalhes do filme em formato JSON.
  404 Not Found - Se o filme com o ID especificado não for encontrado.

### Atualizar 

- **Endpoint:** PUT /movies/{id}
- **Descrição:** Atualiza os detalhes de um filme existente.
- **Corpo da Requisição:**
  ```json
  {
  "titulo": "Título Atualizado",
  "descricao": "Descrição Atualizada",
  "diretor": "Nome do Diretor Atualizado",
  "genero": "Gênero Atualizado",
  "rating": 9.0
}```
- **Respostas:**
  200 OK - O filme foi atualizado com sucesso.
  404 Not Found - Se o filme com o ID especificado não for encontrado.

### Deletar  

- **Endpoint:** DELETE /movies/{id}
- **Descrição:** Deleta um filme pelo ID.
- **Respostas:**
204 No Content - O filme foi deletado com sucesso.
404 Not Found - Se o filme com o ID especificado não for encontrado.
  
### Avaliar 

- **Endpoint:** PATCH /movies/{id}/rate
- **Descrição:** Avalia um filme pelo ID.
- **Parâmetros de Query:**
  rating - Nota para o filme.
- **Respostas:**
  200 OK - O filme foi avaliado com sucesso.
  404 Not Found - Se o filme com o ID especificado não for encontrado.
  
### Indicar um Filme Não Avaliado

- **Endpoint:** GET /movies/unrated
- **Descrição:** Retorna um filme que ainda não foi avaliado.
- **Respostas:**
  200 OK - Detalhes do filme não avaliado em formato JSON.
  204 No Content - Se não houver filmes não avaliados.

### Tratamento de Erro
A API valida os campos obrigatórios utilizando as anotações @NotBlank e @NotNull. Se algum campo obrigatório estiver faltando ou inválido, a resposta será 400 Bad Request com uma mensagem de erro indicando qual campo está faltando.

### Banco de Dados
A aplicação utiliza o banco de dados H2, que é um banco de dados em memória. Isso permite que a aplicação armazene e recupere os dados dos filmes durante a execução.

### Como Executar
1.Clone o repositório:
 ```
git clone https://github.com/AlissomSilva/movie-review-api.git
 ```
2.Navegue até o diretório do projeto:
```
cd movie-review-api
```
3.Execute a aplicação:
```
mvn spring-boot:run
```
A aplicação estará disponível em http://localhost:8080.
