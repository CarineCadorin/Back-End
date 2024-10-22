# Exercício 12: Transações Bancárias

## Objetivo

Crie um aplicativo web Spring Boot que permita realizar transações bancárias entre diferentes contas. Utilize DTOs, Java Records e Mappers para mapear os dados entre as classes.

## Instruções

* Crie um novo projeto Spring Boot com dependência Web.
* Defina duas classes modelo: `Conta` e `Transacao`.
* Defina um service chamado `TransacoesService` que inicializa uma coleção (ArrayList) de `contas`. Crie duas contas: uma com `codigo = "500-1"` e `cliente = "Fulano"` e outra conta com `codigo = "320-2"` e `cliente = "Ciclano"`.
* Defina um DTO `ContaDTO` que representa os dados enviados na solicitação HTTP (`String codigo`, `String cliente`).
* Defina um DTO `TransacaoRequestDTO` que representa os dados enviados na solicitação HTTP (`String origem`, `String destino`, `Double valor`).
* Defina um DTO `TransacaoResponseDTO` que será enviada de volta na resposta HTTP (`ContaDTO origem`, `ContaDTO destino`, `valor`).
  * O DTO `TransacaoResponseDTO` deve retornar o objeto `Conta` completo, não apenas o código e o cliente. Para isso, utilize um mapper chamado `ContaMapper`.
* Implemente uma classe Controller `TransacaoController` que possui um método `gerarTransacao` que aceita um DTO `TransacaoRequestDTO` via POST e retorna um `TransacaoResponseDTO`.

## Entradas (inputs)

````json
{
  "origem": "500-1",
  "destino": "320-2",
  "valor": 100
}
````

## Saídas (outputs)

````json
{
  "origem": { "codigo": "500-1", "cliente": "Fulano" },
  "destino": { "codigo": "320-2", "cliente": "Ciclano" },
  "valor": 100
}
````