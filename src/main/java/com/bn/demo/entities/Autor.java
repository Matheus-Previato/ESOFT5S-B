package com.bn.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="/autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nome;
    private String nascionalidade;
    private LocalDate dataNascimento;

    public Autor(){

    }

    public Autor(Long id, String nome, String nascionalidade, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.nascionalidade = nascionalidade;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
