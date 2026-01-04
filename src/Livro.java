import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataActualizacao;

    public Livro(int id, String titulo, Autor autor, boolean disponivel, LocalDate dataCadastro, LocalDate dataActualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
        this.dataActualizacao = dataActualizacao;
    }

    public int getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor.getNome() +
                ", disponivel=" + disponivel +
                ", dataCadastro=" + dataCadastro +
                ", dataActualizacao=" + dataActualizacao +
                '}';
    }
}
