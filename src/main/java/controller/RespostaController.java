package controller;

import domain.resposta.DadosCreateResposta;
import domain.resposta.DadosListResposta;
import domain.resposta.Resposta;
import domain.resposta.RespostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public ResponseEntity<DadosListResposta> cadastrar(@RequestBody @Valid DadosCreateResposta dados) {
        Resposta resposta = respostaService.cadastrar(dados);
        return ResponseEntity.ok(new DadosListResposta(resposta));
    }

    @GetMapping
    public ResponseEntity<List<DadosListResposta>> listar() {
        List<DadosListResposta> respostas = respostaService.listar();
        return ResponseEntity.ok(respostas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        respostaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}