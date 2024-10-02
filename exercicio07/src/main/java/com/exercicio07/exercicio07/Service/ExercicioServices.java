package com.exercicio07.exercicio07.Service;

import org.springframework.stereotype.Service;

@Service
    public class ExercicioServices {
        public String recomendafilme(String ambientacao, String genero){
            if(ambientacao.equalsIgnoreCase("Scifi") && genero.equalsIgnoreCase("Comedia")){
                return "Homens de Preto";
            }
            if(ambientacao.equalsIgnoreCase("Medieval")&& genero.equalsIgnoreCase("Comédia")) {
                return "Arrival";
            }
            if(ambientacao.equalsIgnoreCase("Scifi")&& genero.equalsIgnoreCase("Drama")) {
                return "Shrek";
            }
            if(ambientacao.equalsIgnoreCase("Medieval")&& genero.equalsIgnoreCase("Drama")) {
                return "Gladiador";
            }
            return "Nenhum filme";
        }
    }

