package com.bn.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutoresController {

    @Autowired
    private ServiceAutor autoresService;

    @GetMapping
    public ResponseEntity<List<Autor>> findAll() {
        List<Autor> autoresModels = autoresService.findAll();
        return ResponseEntity.status(200).body(autoresModels);
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autoresModel) {
        Autor autoresModel1 = autoresService.criarAutor(autoresModel);
        return ResponseEntity.status(201).body(autoresModel1);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Optional<Autor>> findById(@PathVariable Long id) {
        Optional<Autor> model = autoresService.buscarId(id);

        return ResponseEntity.status(200).body(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizarAutor(@PathVariable Long id, @RequestBody Autor autoresModel) {
        Autor model = autoresService.atualizarAutor(id, autoresModel);
        return ResponseEntity.status(200).body(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
        autoresService.deletarAutor(id);
        return ResponseEntity.status(204).build();
    }
}
