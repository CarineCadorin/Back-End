package com.TransacoesBancarias.TransacoesBancarias.Mapper;

import com.TransacoesBancarias.TransacoesBancarias.DTOs.ContaDTO;
import com.TransacoesBancarias.TransacoesBancarias.Entities.Conta;

public class ContaMapper {
    public static ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
