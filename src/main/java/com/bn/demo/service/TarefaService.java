package com.bn.demo.service;

import com.bn.demo.model.Tarefa;
import com.bn.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public void salvar(Tarefa tarefa){
        tarefaRepository.save(tarefa);
    }

    public void excluir(Long id){
        tarefaRepository.deleteById(id);
    }

    public Optional<Tarefa> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public List<Tarefa> buscarTodos(){
        return tarefaRepository.findAll();
    }

    public Tarefa atualizar(Long id, Tarefa tarefa){
        Tarefa entity = tarefaRepository.findById(id).get();
        entity.setDescricao(tarefa.getDescricao());
        entity.setDataVencimento(tarefa.getDataVencimento());
        entity.setConcluida(tarefa.getConcluida());
        return tarefaRepository.save(entity);
    }

}
