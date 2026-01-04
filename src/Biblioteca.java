import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    private List<Autor> autores;
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {
        Autor a1 = new Autor(2, "Romeu Ambriz", LocalDate.of(2003, Month.DECEMBER, 8));
        Autor a2 = new Autor(1, "Monteiro Futila", LocalDate.of(2002, Month.MARCH, 2));
        Autor a3 = new Autor(3, "Paixão Raimundo", LocalDate.of(2003, Month.APRIL, 14));

        this.autores = new ArrayList<>();
        autores.add(a2);
        autores.add(a3);
        autores.add(a1);

        this.livros = new ArrayList<>();
        livros.add(new Livro(1, "Roube Como um Artista", a2, false , LocalDate.now(), LocalDate.now()));
        livros.add(new Livro(2, "Comunicação Assertiva", a3, true , LocalDate.now(), LocalDate.now()));
        livros.add(new Livro(3, "Habitos Atomicos", a1, true , LocalDate.now(), LocalDate.now()));
    }

    public void emprestarLivro(int idLivro, String nomeCliente){
        int novoId = this.emprestimos.size() + 1;
        Livro livro = this.procurarLivro(idLivro);
        Emprestimo e = new Emprestimo(novoId, livro, nomeCliente, LocalDate.now(), LocalDate.now().plusMonths(1));
    }

    private Livro procurarLivro(int idLivro){
        for (Livro livro : this.livros) {
            if (livro.getId() == idLivro) return livro;
        }
        return null;
    }

    public void listarLivrosDisponiveis(){
        for (Livro livro : this.livros) {
            if (livro.isDisponivel()){
                System.out.println(livro.toString());
            }
        }
    }
}
