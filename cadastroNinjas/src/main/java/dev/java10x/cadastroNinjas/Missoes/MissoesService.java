package dev.java10x.cadastroNinjas.Missoes;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MissoesService{

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Adicionar Missoes (CREATE)
    public MissoesModel adicionarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    // Ver todas as Missoes (READ)
    public List<MissoesModel> VerTodasMissoes(){
        return missoesRepository.findAll();
    }

    // Buscar Missoes por ID
    public MissoesModel missoesID(Long id){
        Optional<MissoesModel> missoesid = missoesRepository.findById(id);
        return missoesid.orElse(null);
    }

    // Alterar missoes (UPDATE)
    public MissoesModel AlterarMissao(Long id, MissoesModel missaoAlterada){
        if (missoesRepository.existsById(id)) {
            missaoAlterada.setID(id);
            return missoesRepository.save(missaoAlterada);
        }
        else return null;
    }

    // Deletar Missoes(DELETE)
    public void deletarMissoes(Long id){
        missoesRepository.deleteById(id);
    }
}
