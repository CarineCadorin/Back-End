package com.example.exercicio8;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/fipe")
public class FipeController {

    private RestTemplate restTemplate;

    public FipeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/valor")
    public ResponseEntity<CarroResponse> getValorFipe(@RequestBody CarroRequest carroRequest) {
        // 1. Obter o código da marca
        String urlMarca = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        Marca[] marcas = restTemplate.getForObject(urlMarca, Marca[].class);
        String codigoMarca = buscarCodigoMarca(marcas, carroRequest.getMarca());

        // 2. Obter o código do modelo
        String urlModelo = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + codigoMarca + "/modelos";
        Modelos modelos = restTemplate.getForObject(urlModelo, Modelos.class);
        String codigoModelo = buscarCodigoModelo(modelos.getModelos(), carroRequest.getModelo());

        // 3. Obter o código do ano
        String urlAno = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
        Ano[] anos = restTemplate.getForObject(urlAno, Ano[].class);
        String codigoAno = buscarCodigoAno(anos, carroRequest.getAno());

        // 4. Obter o valor da Tabela FIPE
        String urlValor = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + codigoAno;
        ValorFipe valorFipe = restTemplate.getForObject(urlValor, ValorFipe.class);

        // 5. Retornar o valor
        CarroResponse response = new CarroResponse();
        response.setValor(Double.parseDouble(valorFipe.getValor().replace("R$", "").replace(".", "").replace(",", ".")));
        response.setMes(valorFipe.getMesReferencia());

        return ResponseEntity.ok(response);
    }

    private String buscarCodigoMarca(Marca[] marcas, String nomeMarca) {
        for (Marca marca : marcas) {
            if (marca.getNome().equalsIgnoreCase(nomeMarca)) {
                return marca.getCodigo();
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca não encontrada");
    }

    private String buscarCodigoModelo(List<Modelo> modelos, String nomeModelo) {
        for (Modelo modelo : modelos) {
            if (modelo.getNome().equalsIgnoreCase(nomeModelo)) {
                return modelo.getCodigo();
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo não encontrado");
    }

    private String buscarCodigoAno(Ano[] anos, int ano) {
        for (Ano anoModelo : anos) {
            if (anoModelo.getNome().startsWith(String.valueOf(ano))) {
                return anoModelo.getCodigo();
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ano não encontrado");
    }
}

