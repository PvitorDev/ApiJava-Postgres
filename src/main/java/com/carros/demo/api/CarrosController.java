package com.carros.demo.api;
import com.carros.demo.domain.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.carros.demo.domain.CarroService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    @Autowired
    private CarroService service;

    @GetMapping()
    public Iterable<Carro> get(){
        return  service.getCarros();
    }
    @GetMapping("/{id}")
    public Optional<Carro> getId(@PathVariable("id") Long id){
        return  service.getCarroById(id);
    }
    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getTipo(@PathVariable("tipo") String tipo){
        return  service.getCarroByTipo(tipo);
    }

    @PostMapping
    public String post(@RequestBody Carro carro){
        Carro c = service.insert(carro);
        return "Carro salvo com sucesso " + c.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Carro carro){
        Carro c = service.update(carro, id);
        return "Carro atualizado com sucesso " + c.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
         service.delete(id);
        return "Carro deletado com sucesso " ;
    }
}
