package dev.java10x.cadastroNinjas.Ninjas;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    //Injeçao de dependencia
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar ninjas
    public List<NinjaDTO> listarNinjas (){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar ninjas por ID
    public NinjaDTO listarNinjaID (Long id){
        Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
        return ninjaID.map(ninjaMapper::map).orElse(null);
    }

    //Adicionar Ninja
    public NinjaDTO adicionarNinja (NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar Ninja - Tem que ser um metodo void
    public void deletarNinja (Long id){
        ninjaRepository.deleteById(id);
    }

    //Alterar dados Ninja
    public NinjaDTO alterarNinja (Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninJaExistente = ninjaRepository.findById(id);
        if (ninJaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}