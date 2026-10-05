package service;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro){
        livros.add(livro);
    }

    public void listarLivros(){
        for (Livro livro : livros){
            System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
        }
    }

    public Livro buscarLivroPorId(int id){
        for (Livro livro : livros){
            if (livro.getId() == id){
                return livro;
            }
        }
        return null;
    }

    public void cadastrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void listarUsuarios(){
        for (Usuario usuario: usuarios){
            System.out.println("Id: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", E-mail: " + usuario.getEmail());
        }
    }

    public Usuario buscarUsuarioPorId(int id){
        for (Usuario usuario : usuarios){
            if (usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }

    public Emprestimo realizarEmprestimo(int id, int idUsuario, int idLivro){
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Livro livro = buscarLivroPorId(idLivro);

        if (livro == null){
            System.out.println("livro não encontrado");
            return null;
        }

        if (usuario == null || !livro.isDisponivel()){
            System.out.println("Não foi possivel realizar emprestimo, livro indisponível");
            return null;
        }

        livro.emprestar();
        Emprestimo emprestimo = new Emprestimo(id, usuario, livro, LocalDate.now(), LocalDate.now().plusDays(7));
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void listarEmprestimos(){
        System.out.println("# EMPRÉSTIMOS");

        for (Emprestimo emprestimo : emprestimos){

            System.out.println("Id usuário: " + emprestimo.getUsuario().getId() + ", Nome: " + emprestimo.getUsuario().getNome() +
                    ", E-mail: " + emprestimo.getUsuario().getEmail()
            );

            System.out.println("Id livro: " + emprestimo.getLivro().getId() + ", Título: " + emprestimo.getLivro().getTitulo() +
                    ", Autor: " + emprestimo.getLivro().getAutor()
            );

            System.out.println("data emprestimo: " + emprestimo.getDataEmprestimo());
            System.out.println("data devolucao: " + emprestimo.getDataDevolucao());

            System.out.println("==============================");
        }
    }

    public Emprestimo buscarEmprestimoPorId(int id){
        for (Emprestimo emprestimo : emprestimos){
            if (emprestimo.getId() == id){
                return emprestimo;
            }
        }
        return null;
    }

    public void devolverLivro(int id){
        Emprestimo emprestimo = buscarEmprestimoPorId(id);

        if (emprestimo == null){
            System.out.println("emprestimo não encontrado");
            return;
        }
        if (emprestimo.isAtivo()){
            emprestimo.getLivro().devolver();
            emprestimo.finalizar();
        } else {
            System.out.println("emprestimo ja finalizado");
        }
    }

}
