package br.com.pedrozanon.forum.controller;

import br.com.pedrozanon.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.pedrozanon.forum.controller.dto.TopicoDto;
import br.com.pedrozanon.forum.controller.form.TopicoForm;
import br.com.pedrozanon.forum.modelo.Topico;
import br.com.pedrozanon.forum.repository.CursoRepository;
import br.com.pedrozanon.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<TopicoDto> persist(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
        Topico topico = topicoForm.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    public DetalhesDoTopicoDto detalhar(@PathVariable Long id) {
        Topico topico = topicoRepository.getOne(id);
        return new DetalhesDoTopicoDto(topico);
    }
}
