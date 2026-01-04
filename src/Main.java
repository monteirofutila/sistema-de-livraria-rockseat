import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca livraria = new Biblioteca();
        Scanner key = new Scanner(System.in);

        //Adicionar autores
        Autor a1 = new Autor(2, "Romeu Ambriz", LocalDate.of(2003, Month.DECEMBER, 8));
        Autor a2 = new Autor(1, "Monteiro Futila", LocalDate.of(2002, Month.MARCH, 2));
        Autor a3 = new Autor(3, "Paixão Raimundo", LocalDate.of(2003, Month.APRIL, 14));

        livraria.adicionarAutor(a1);
        livraria.adicionarAutor(a2);
        livraria.adicionarAutor(a3);

        //Adicionar livros
        Livro l1 = new Livro(1, "Roube Como um Artista", a2);
        Livro l2 = new Livro(2, "Comunicação Assertiva", a3);
        Livro l3 = new Livro(3, "Habitos Atomicos", a1);

        livraria.adicionarLivro(l1);
        livraria.adicionarLivro(l2);
        livraria.adicionarLivro(l3);

        while(true) {
            System.out.println("Deseja ver a lista de livros disponiveis?");
            String answer = key.nextLine();

            if (answer.equals("SIM")) {
                List<Livro> livrosDisponiveis = livraria.listarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()){
                    System.out.println("Não há livros disponíveis no momento.");
                }else {
                    System.out.println("Livros disponiveis: ");
                    for (Livro livro: livrosDisponiveis){
                        System.out.println(livro.toString());
                    }

                    System.out.println("Digite o ID do livro que deseja emprestar: ");
                    int idLivro = key.nextInt();
                    key.nextLine();
                    Livro livroSelecionado = livraria.procurarLivroPorId(idLivro);
                    if(livroSelecionado.isDisponivel()){
                        System.out.println("Informe o seu Nome");
                        String nomeCliente = key.nextLine();

                        livraria.emprestarLivro(livroSelecionado, nomeCliente);
                        System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeCliente);
                    }else {
                        System.out.println("Livro não encontrado ou não disponível para empréstimo.");
                    }
                }

            } else if (answer.equals("NAO")) {
                System.out.println("Obrigado por utilizar o sistema da Livraria.");
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, responda com 'SIM' ou 'NAO'.");
            }
        }

        key.close();

    }
}
