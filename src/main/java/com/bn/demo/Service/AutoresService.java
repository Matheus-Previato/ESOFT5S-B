package com.bn.demo.Service;

import com.bn.demo.Models.AutorModel;
import com.bn.demo.Repositories.AutoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {

    private final AutoresRepository autoresRepository;

    public AutoresService(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    public AutorModel saveAutor(AutorModel autor){
        return autoresRepository.save(autor);
    }

    public Optional<AutorModel> findAutorById(Long id){
        return autoresRepository.findById(id);
    }

    public List<AutorModel> listAllAutores(){
        return autoresRepository.findAll();
    }

    public void deleteAutorById(Long id){
         autoresRepository.deleteById(id);
    }
}
