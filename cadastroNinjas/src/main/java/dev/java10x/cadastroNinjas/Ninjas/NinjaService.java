package dev.java10x.cadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class NinjaService {
    public Scanner sacann = new Scanner(System.in);
    //Injeçao de dependencia
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas (){
        return ninjaRepository.findAll();
    }

}
