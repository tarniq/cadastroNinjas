package dev.java10x.cadastroNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService{

    private MissoesMapper missoesMapper;
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesMapper missoesMapper, MissoesRepository missoesRepository) {
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }

    // Adicionar Missoes (CREATE)
    public MissoesDTO adicionarMissao(MissoesDTO missao){
        MissoesModel missaoNova = missoesMapper.map(missao);
        MissoesModel missaoSalva = missoesRepository.save(missaoNova);
        return missoesMapper.map(missaoSalva);
    }

    // Ver todas as Missoes (READ)
    public List<MissoesDTO> VerTodasMissoes(){
        List<MissoesModel> missoesModels = missoesRepository.findAll();

        return missoesModels.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Buscar Missoes por ID
    public MissoesDTO missoesID(Long id){
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
        return missaoExiste.map(missoesMapper::map).orElse(null);
    }

    // Alterar missoes (UPDATE)
    public MissoesDTO alterarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
        if (missaoExiste.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setID(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    // Deletar Missoes(DELETE)
    public void deletarMissoes(Long id){
        missoesRepository.deleteById(id);
    }
}

