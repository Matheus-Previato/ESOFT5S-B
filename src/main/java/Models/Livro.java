package Models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdLivro;
    private String Titulo;
    private String Autor;
    private Integer anoPublicacao;

    public Livro() {}

    public Long getIdLivro() {
        return IdLivro;
    }

    public void setIdLivro(Long idLivro) {
        IdLivro = idLivro;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
