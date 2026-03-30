package com.bn.demo.services;


import com.bn.demo.entities.Autor;
import com.bn.demo.repositores.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired

    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        autorRepository.deleteById(id);
    }
}
