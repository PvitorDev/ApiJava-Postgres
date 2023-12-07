package com.carros.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    private CarroRepository rep;
    public Iterable<Carro> getCarros(){
        return  rep.findAll();
    }

    public Optional<Carro> getCarroById(Long id){
        return rep.findById(id);
    }
    public Iterable<Carro> getCarroByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }
    public Carro insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possivel inserir o registro");
        return rep.save(carro);
    }
    public Carro update(Carro carro, Long id) {
        Assert.notNull(id,"Não foi possivel encontrar o registro");
        Optional<Carro> carroUpdate = getCarroById(id);
        if(carroUpdate.isPresent()){
            Carro data = carroUpdate.get();
            data.setNome(carro.getNome());
            data.setTipo(carro.getTipo());
            System.out.println("Carro id " + data.getId());
            rep.save(data);

            return  data;
        }else{
         throw new RuntimeException("Não foi possivel atualizar registro");
        }
    }
    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if(carro.isPresent()){
            rep.deleteById(id);
        }
    }
    public List<Carro> getCarrosFakes(){
        List<Carro>carros = new ArrayList<>();

        Carro fusca = new Carro(1L, "Fusca");
        Carro parati = new Carro(2L, "Parati");
        Carro ferrari = new Carro(3L, "Ferrari" );
        carros.add(fusca);
        carros.add(parati);
        carros.add(ferrari);

        return  carros;
    }



}
