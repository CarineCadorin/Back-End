package com.TransacoesBancarias.TransacoesBancarias.Services;

import com.TransacoesBancarias.TransacoesBancarias.Entities.Conta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {
    private List<Conta> contas;

    public TransacoesService() {
        contas = new ArrayList<>();
        contas.add(new Conta("500-1", "Fulano"));
        contas.add(new Conta("320-2", "Ciclano"));
    }

    public Conta getContaPorCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
