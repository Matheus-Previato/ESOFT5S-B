package com.bn.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livro")
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Titulo_livro")
    private String titulo;

    private String autor;

    @Column(name = "anoPublicação_livro")
    private Integer anoPublicação;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicação() {
        return anoPublicação;
    }

    public void setAnoPublicação(Integer anoPublicação) {
        this.anoPublicação = anoPublicação;
    }
}
