package domain.topico;

import domain.curso.Curso;
import domain.curso.CursoRepository;
import domain.user.User;
import domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional(readOnly = true)
    public List<DadosListTopico> listar() {
        return topicoRepository.findAll().stream()
                .map(DadosListTopico::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Topico criarTopico(DadosCreateTopico dados) {
        User user = userRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        Curso curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        Topico topico = new Topico(dados, user, curso);
        return topicoRepository.save(topico);
    }

    @Transactional
    public Topico atualizarStatusTopico(DadosUpdateStatusTopico dados) {
        Topico topico = topicoRepository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        topico.setStatus(dados.status());
        return topicoRepository.save(topico);


    }

    @Transactional
    public void deletarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("Tópico não encontrado");
        }
        topicoRepository.deleteById(id);
    }

}