package br.com.pedrozanon.forum.controller;

import br.com.pedrozanon.forum.controller.dto.TopicoDto;
import br.com.pedrozanon.forum.controller.form.TopicoForm;
import br.com.pedrozanon.forum.modelo.Topico;
import br.com.pedrozanon.forum.repository.CursoRepository;
import br.com.pedrozanon.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        if(nomeCurso == null) {
            return TopicoDto.converter(topicoRepository.findAll());
        }
        else {
            return TopicoDto.converter(topicoRepository.findByCursoNome(nomeCurso));
        }
    }

    @PostMapping
    public void persist(@RequestBody TopicoForm topicoForm) {
        Topico topico = topicoForm.converter(cursoRepository);
        topicoRepository.save(topico);
    }
}
