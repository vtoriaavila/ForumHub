package domain.resposta;
import domain.topico.Topico;
import domain.topico.TopicoRepository;
import domain.user.User;
import domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository responseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Resposta cadastrar(DadosCreateResposta dados) {
        Optional<User> autorOpt = userRepository.findById(dados.autorId());
        Optional<Topico> topicoOpt = topicoRepository.findById(dados.topicoId());

        if (autorOpt.isPresent() && topicoOpt.isPresent()) {
            User autor = autorOpt.get();
            Topico topico = topicoOpt.get();
            Resposta response = new Resposta(dados, autor, topico);
            return responseRepository.save(response);
        }

        throw new IllegalArgumentException("Autor ou Tópico não encontrado");
    }

    public List<DadosListResposta> listar() {
        return responseRepository.findAll().stream().map(DadosListResposta::new).toList();
    }

    public void deletar(Long id) {
        responseRepository.deleteById(id);
    }
}