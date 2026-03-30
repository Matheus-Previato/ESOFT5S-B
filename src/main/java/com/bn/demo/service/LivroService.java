package com.bn.demo.Service;

import com.bn.demo.Model.LivroModel;
import com.bn.demo.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public LivroModel save(LivroModel livroModel){
        return repository.save(livroModel);
    }

    public List<LivroModel>listar(){
        return repository.findAll();
    }

    public Optional<LivroModel>BuscaPorId(Long id){
        return repository.findById(id);
    }

    public void Deletar(Long id){
        repository.deleteById(id);
    }
}
