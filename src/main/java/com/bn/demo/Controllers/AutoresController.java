package com.bn.demo.Controllers;

import com.bn.demo.Models.AutorModel;
import com.bn.demo.Service.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    }
}
