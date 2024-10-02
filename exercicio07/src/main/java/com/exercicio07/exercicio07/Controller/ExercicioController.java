package com.exercicio07.exercicio07.Controller;
import com.exercicio07.exercicio07.Service.ExercicioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ExercicioController {


    @Autowired
    private ExercicioServices exercicioServices;

    @GetMapping("/exercicio")
    public String recomendafilme(@RequestParam String ambientacao, @RequestParam String genero){
        return exercicioServices.recomendafilme(ambientacao, genero);
    }
}
