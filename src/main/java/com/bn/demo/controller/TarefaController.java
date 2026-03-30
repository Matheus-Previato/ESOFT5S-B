package com.bn.demo.controller;

import com.bn.demo.model.Tarefa;
import com.bn.demo.service.TarefaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa){
        tarefaService.salvar(tarefa);
        return ResponseEntity.ok(tarefa);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa){
        Tarefa entity = tarefaService.atualizar(id, tarefa);
        return ResponseEntity.ok(entity);
    }

    @GetMapping
    private ResponseEntity<List<Tarefa>> buscarTodos(){
        List<Tarefa> tarefas = tarefaService.buscarTodos();
        return tarefas.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(tarefas);
    }

    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.buscarPorId(id);
        return tarefa.isPresent()
                ? ResponseEntity.ok().body(tarefa.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id){
        tarefaService.excluir(id);
        return ResponseEntity.status(204).build();
    }


}
