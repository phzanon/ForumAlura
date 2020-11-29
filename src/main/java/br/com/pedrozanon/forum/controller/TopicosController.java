package br.com.pedrozanon.forum.controller;

import br.com.pedrozanon.forum.controller.dto.TopicoDto;
import br.com.pedrozanon.forum.modelo.Curso;
import br.com.pedrozanon.forum.modelo.Topico;
import br.com.pedrozanon.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        return TopicoDto.converter(topicoRepository.findAll());
    }
}
