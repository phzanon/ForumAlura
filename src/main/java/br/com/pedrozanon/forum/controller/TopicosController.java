package br.com.pedrozanon.forum.controller;

import br.com.pedrozanon.forum.controller.dto.TopicoDto;
import br.com.pedrozanon.forum.modelo.Curso;
import br.com.pedrozanon.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        Topico topico = new Topico("Duvida teste", "Duvida com Spring", new Curso("Spring", "Programação"));
        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}
