# Spotify Clone API

## Casos de uso:
- Acessar informações de um ouvinte
- Manipular músicas, playlists e artistas

## Recursos
- `ouvintes`
- `musicas`
- `playlists`
- `artistas`

## Endpoints

| Descrição                                | URI                                            | Método HTTP | Corpo                                                                                         | Resposta Esperada        | Erros esperados                                      |
|------------------------------------------|------------------------------------------------|-------------|-----------------------------------------------------------------------------------------------|--------------------------|------------------------------------------------------|
| Retornar um ouvinte                      | `GET /ouvintes/{ouvinte-id}`                   | `GET`       | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - ouvinte não foi encontrado.        |
| Criar um novo ouvinte                    | `POST /ouvintes`                               | `POST`      | `{ "nome": "João", "email": "joao@email.com" }`                                               | `201 Created`            | `400 Bad Request` - dados inválidos.                 |
| Atualizar um ouvinte                     | `PUT /ouvintes/{ouvinte-id}`                   | `PUT`       | `{ "nome": "João", "email": "joao@novoemail.com" }`                                           | `200 OK`                 | `404 Not Found` - ouvinte não foi encontrado.        |
| Deletar um ouvinte                       | `DELETE /ouvintes/{ouvinte-id}`                | `DELETE`    | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - ouvinte não foi encontrado.        |
| Retornar todas as músicas                | `GET /musicas`                                 | `GET`       | Vazio                                                                                         | `200 OK`                 | Nenhum                                                 |
| Retornar uma música                      | `GET /musicas/{musica-id}`                     | `GET`       | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - música não foi encontrada.         |
| Criar uma nova música                    | `POST /musicas`                                | `POST`      | `{ "titulo": "Nova Música", "artistaId": 123, "duracao": 180 }`                               | `201 Created`            | `400 Bad Request` - dados inválidos.                 |
| Atualizar uma música                     | `PUT /musicas/{musica-id}`                     | `PUT`       | `{ "titulo": "Música Atualizada", "artistaId": 123, "duracao": 200 }`                         | `200 OK`                 | `404 Not Found` - música não foi encontrada.         |
| Deletar uma música                       | `DELETE /musicas/{musica-id}`                  | `DELETE`    | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - música não foi encontrada.         |
| Retornar todas as playlists              | `GET /playlists`                               | `GET`       | Vazio                                                                                         | `200 OK`                 | Nenhum                                                 |
| Retornar uma playlist                    | `GET /playlists/{playlist-id}`                 | `GET`       | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - playlist não foi encontrada.       |
| Criar uma nova playlist                  | `POST /playlists`                              | `POST`      | `{ "nome": "Minha Playlist", "musicaIds": [1, 2, 3], "ouvinteId": 456 }`                      | `201 Created`            | `400 Bad Request` - dados inválidos.                 |
| Atualizar uma playlist                   | `PUT /playlists/{playlist-id}`                 | `PUT`       | `{ "nome": "Playlist Atualizada", "musicaIds": [1, 2, 3, 4] }`                                | `200 OK`                 | `404 Not Found` - playlist não foi encontrada.       |
| Deletar uma playlist                     | `DELETE /playlists/{playlist-id}`              | `DELETE`    | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - playlist não foi encontrada.       |
| Retornar todos os artistas               | `GET /artistas`                                | `GET`       | Vazio                                                                                         | `200 OK`                 | Nenhum                                                 |
| Retornar um artista                      | `GET /artistas/{artista-id}`                   | `GET`       | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - artista não foi encontrado.        |
| Criar um novo artista                    | `POST /artistas`                               | `POST`      | `{ "nome": "Novo Artista" }`                                                                  | `201 Created`            | `400 Bad Request` - dados inválidos.                 |
| Atualizar um artista                     | `PUT /artistas/{artista-id}`                   | `PUT`       | `{ "nome": "Artista Atualizado" }`                                                            | `200 OK`                 | `404 Not Found` - artista não foi encontrado.        |
| Deletar um artista                       | `DELETE /artistas/{artista-id}`                | `DELETE`    | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - artista não foi encontrado.        |
| Relacionar uma música com um artista     | `GET /musicas/{musica-id}/artista`             | `GET`       | Vazio                                                                                         | `200 OK`                 | `404 Not Found` - música ou artista não foram encontrados. |
