package dev.java10x.cadastroNinjas.Missoes;

/*import dev.java10x.cadastroNinjas.Ninjas.NinjaModel;*/
import org.springframework.stereotype.Component;

/*import java.util.List;
import java.util.stream.Collectors;*/

@Component
public class MissoesMapper {



    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();

        missoesModel.setID(missoesDTO.getID());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setCredito(missoesDTO.getCredito());
        missoesModel.setRank(missoesDTO.getRank());
        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO missoesDTO = new MissoesDTO();

        missoesDTO.setID(missoesModel.getID());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setCredito(missoesModel.getCredito());
        missoesDTO.setRank(missoesModel.getRank());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}
