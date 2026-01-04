import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca livraria = new Biblioteca();

        Scanner key = new Scanner(System.in);
        int idLivro;
        String nomeCliente;

        while(true) {
            System.out.println("Deseja ver a lista de livros disponiveis?");
            String answer = key.nextLine();
            if (answer.equals("SIM")) {
                livraria.listarLivrosDisponiveis();

                System.out.println("Escolhe um livro pelo seu ID");
                idLivro = key.nextInt();
                System.out.println("Informe o seu Nome");
                nomeCliente = key.nextLine();

                livraria.emprestarLivro(idLivro, nomeCliente);

                System.out.println("Emprestimo efetuado com sucesso!");
                break;
            } else {
                System.out.println("Obrigado por visitar nossa Livraria, volte sempre!");
                break;
            }
        }

    }
}
