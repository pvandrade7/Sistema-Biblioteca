import java.time.LocalDate;
import java.util.Scanner;

import model.Emprestimo;
import model.Livro;
import model.Usuario;
import service.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BibliotecaService biblioteca = new BibliotecaService();


        int opcao;

        do {
            System.out.println("===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livro");
            System.out.println("3 - Cadatrar usuario");
            System.out.println("4 - Listar usuário");
            System.out.println("5 - Cadastrar empréstimos");
            System.out.println("6 - Listar empréstimo");
            System.out.println("7 - Devolver Livro");
            System.out.println("0 - Sair");

            System.out.println("insira sua opção:");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Id do livro");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Título do livro");
                    String titulo = sc.nextLine();
                    System.out.println("Nome do autor");
                    String autor = sc.nextLine();

                    biblioteca.cadastrarLivro(new Livro(id, titulo, autor));
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.println("Id do usuário");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome do usuário");
                    String nome = sc.nextLine();
                    System.out.println("E-mail do usuário");
                    String email = sc.nextLine();

                    biblioteca.cadastrarUsuario(new Usuario(idUsuario, nome, email));
                    break;

                case 4:
                    biblioteca.listarUsuarios();
                    break;

                case 5:
                    System.out.println("Id do empréstimo");
                    int idEmprestimo = sc.nextInt();
                    System.out.println("Id do usuário");
                    int idUsuarioEmprestimo = sc.nextInt();
                    System.out.println("Id do livro");
                    int idLivroEmprestimo = sc.nextInt();

                    biblioteca.realizarEmprestimo(idEmprestimo, idUsuarioEmprestimo, idLivroEmprestimo);
                    break;

                case 6:
                    biblioteca.listarEmprestimos();
                    break;

                case 7:
                    System.out.println("Id do empréstimo");
                    int idEmprestimoDevolucao = sc.nextInt();
                    biblioteca.devolverLivro(idEmprestimoDevolucao);
                    break;
            }

        } while (opcao != 0);
    }
}