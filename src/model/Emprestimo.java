package model;
import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate prazoDevolucao;
    private LocalDate dataDevolucao;
    private boolean ativo;

    public Emprestimo(int id, Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate prazoDevolucao) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.prazoDevolucao = prazoDevolucao;
        this.dataDevolucao = null;
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return prazoDevolucao;
    }

    public void setPrazoDevolucao(LocalDate prazoDevolucao) {
        this.prazoDevolucao = prazoDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void finalizar(){
        if (ativo){
            ativo = false;
            dataDevolucao = LocalDate.now();
            return;
        }
        System.out.println("emprestimo ja finalizado");
    }
}
