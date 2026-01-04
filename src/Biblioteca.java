import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Autor> autores = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    //Gerenciamento de livros
    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return this.livros;
    }

    public Livro procurarLivroPorId(int idLivro){
        for (Livro livro : this.livros) {
            if (livro.getId() == idLivro) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> listarLivrosDisponiveis(){
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    //Gerenciamento de autores
    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public List<Autor> listarAutores() {
        return this.autores;
    }

    //Gerenciamento de emprestimos
    public void emprestarLivro(Livro livro, String nomeCliente) {
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, nomeCliente);
            this.emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }

    public void devolverLivro(int idEmprestimo) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getId() == idEmprestimo) {
                emprestimo.devolverLivro();
                break;
            }
        }
    }

    public List<Emprestimo> listarEmprestimos() {
        return this.emprestimos;
    }
}
