package com.TransacoesBancarias.TransacoesBancarias.DTOs;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {}
