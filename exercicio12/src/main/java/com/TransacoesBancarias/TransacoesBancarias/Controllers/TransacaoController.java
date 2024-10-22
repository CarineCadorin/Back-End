package com.TransacoesBancarias.TransacoesBancarias.Controllers;

import com.TransacoesBancarias.TransacoesBancarias.DTOs.TransacaoRequestDTO;
import com.TransacoesBancarias.TransacoesBancarias.DTOs.TransacaoResponseDTO;
import com.TransacoesBancarias.TransacoesBancarias.Entities.Conta;
import com.TransacoesBancarias.TransacoesBancarias.Entities.Transacao;
import com.TransacoesBancarias.TransacoesBancarias.Mapper.ContaMapper;
import com.TransacoesBancarias.TransacoesBancarias.Services.TransacoesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacoesService transacoesService;

    public TransacaoController(TransacoesService transacoesService) {
        this.transacoesService = transacoesService;
    }

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO transacaoRequest) {
        Conta origem = transacoesService.getContaPorCodigo(transacaoRequest.origem());
        Conta destino = transacoesService.getContaPorCodigo(transacaoRequest.destino());

        if (origem == null || destino == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta não encontrada");
        }

        Transacao transacao = new Transacao(origem, destino, transacaoRequest.valor());

        return new TransacaoResponseDTO(
                ContaMapper.toDTO(transacao.getOrigem()),
                ContaMapper.toDTO(transacao.getDestino()),
                transacao.getValor()
        );
    }
}

