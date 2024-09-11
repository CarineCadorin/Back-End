# Exercício 07: Controladores Web

## Objetivo

Utilizando o framework Spring Web, implemente um controlador que receba uma entrada por query strings e retorne uma resposta. Utilize um dos exercícios propostos anteriores como base.

> Exemplo: Um controlador que recebe duas query strings com genero e ambientação e retorna uma sugestão de filme (como no [exercício 01](./exercicio01.md)).

## Instruções

* Crie um novo projeto Spring Boot usando o Spring Initializr.
* Defina uma classe de controlador com a anotação `@RestController`.
* Crie um método que receba uma entrada por query strings e retorne uma resposta.


## Entradas (inputs)

````txt
http://localhost:8080/recomendar?genero=acao&ambiente=futurista
````

## Saídas (outputs)

````txt
Homens de Preto
````