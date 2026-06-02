package dev.java10x.cadastroNinjas.Ninjas;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<NinjaModel> listarNinjas (){
        return ninjaRepository.findAll();
    }

    // Listar ninjas por ID
    public NinjaModel listarNinjaID (Long id){
        Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
        return ninjaID.orElse(null);
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
    public NinjaModel alterarNinja (Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        else return null;
    }
}