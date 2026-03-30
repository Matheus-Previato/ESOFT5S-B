package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.TarefaServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaServices tarefaServices;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> tarefaFindAll(){
        List<TarefaModel> model = tarefaServices.tarefaFindAll();
        return ResponseEntity.status(200).body(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TarefaModel>> tarefaFindById(@PathVariable Long id){
        Optional<TarefaModel> model = tarefaServices.tarefaFindById(Id);

        return ResponseEntity.status(200).body(model);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel){
        tarefaServices.criarTarefa(model);
        return ResponseEntity.status(201).body(model);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> mudarDescricaoTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel) {
        TarefaModel tarefa = tarefaService.findById(id).get();
        tarefa.setDescricao(tarefaModel.getDescricao());
        return ResponseEntity.status(200).body(tarefa);
    }

    @DeleteMapping
    public ResponseEntity<Void> apagarTarefa(@PathVariable Long id){
        tarefaServices.deletarTarefa(id);
        return ResponseEntity.status(204).build();
    }

}
