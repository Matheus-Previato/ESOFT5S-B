package com.bn.demo.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAutor {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> findAll() {return autoresRepository.findAll();}

    public Autor criarAutor(Autor autoresModel) {
        return autoresRepository.save(autoresModel);
    }

    public Optional<Autor> buscarId(Long id){return autoresRepository.findById(id);}

    public Autor atualizarAutor(Long id, Autor autoresModel){
        Autores autor =  buscarId(id).get();
        autor.setNome(autoresModel.getNome());

        return autoresRepository.save(autor);
    }

    public void deletarAutor(Long id) {
        autoresRepository.deleteById(id);
    }
}
