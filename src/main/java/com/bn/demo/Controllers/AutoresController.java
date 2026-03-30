package com.bn.demo.Controllers;

<<<<<<< HEAD
import com.bn.demo.Models.AutorModel;
import com.bn.demo.Service.AutoresService;
=======
>>>>>>> PedroMCarnelossi
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.net.URI;
import java.util.List;

@RestController
public class AutoresController {

    @Autowired
    private AutoresService autoresService;

    @PostMapping("/autores")
    public ResponseEntity<AutorModel> salvarAutor(@RequestBody AutorModel autor){
        AutorModel autorSalvo = autoresService.saveAutor(autor);

        URI location = URI.create("/autor/" + autorSalvo.getId());

        return ResponseEntity.created(location).body(autorSalvo);
    }

    @GetMapping("/autores")
    public ResponseEntity<List<AutorModel>> getAllAutores(){
        return ResponseEntity.ok(autoresService.listAllAutores());
    }

    @GetMapping("/autores/{id}")
    public ResponseEntity<AutorModel> getAutorById(@PathVariable Long id){
        return autoresService.findAutorById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/autores/{id}")
    public ResponseEntity<Void> deleteAutorById(@PathVariable("id") Long id){
        autoresService.deleteAutorById(id);
        return ResponseEntity.noContent().build();
=======
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
>>>>>>> PedroMCarnelossi
    }
}
