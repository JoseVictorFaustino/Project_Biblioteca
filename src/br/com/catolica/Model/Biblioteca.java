package br.com.catolica.Model;

public class Biblioteca {
    private String nome;
    private String endereco;
    private Livro[] livrosDisponiveis;
    private int contadorLivros;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.livrosDisponiveis = new Livro[100];
        this.contadorLivros = 0;
    }

    public void verificarDisponibilidade(String titulo) {
        for (int i = 0; i < contadorLivros; i++) {
            Livro livro = livrosDisponiveis[i];
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.getQuantidadeEstoque() > 0) {
                System.out.println("O livro está disponível.");
                return;
            }
        }
        System.out.println("O livro não está disponível.");
    }

    public void cadastrarLivro(Livro livro) {
        if (contadorLivros < livrosDisponiveis.length) {
            livrosDisponiveis[contadorLivros] = livro;
            contadorLivros++;
            System.out.println("Livro cadastrado com sucesso.");
        } else {
            System.out.println("Limite de livros na biblioteca alcançado.");
        }
    }

    public Livro localizarLivroPorTitulo(String titulo) {
        for (int i = 0; i < contadorLivros; i++) {
            Livro livro = livrosDisponiveis[i];
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        System.out.println("Livro não encontrado.");
        return null;
    }

    public Livro localizarLivroPorAutor(String autor) {
        for (int i = 0; i < contadorLivros; i++) {
            Livro livro = livrosDisponiveis[i];
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println("Autor encontrado com sucesso");
                return livro;
            }
        }
        System.out.println("Livro não encontrado.");
        return null;
    }

    public void emprestarLivro(Usuario usuario, String titulo) {
        if (usuario.podeEmprestar()) {
            Livro livro = localizarLivroPorTitulo(titulo);
            if (livro != null && livro.getQuantidadeEstoque() > 0) {
                livro.emprestar();
                usuario.adicionarLivro();
                System.out.println("Empréstimo realizado com sucesso.");
            } else {
                System.out.println("Livro não disponível para empréstimo.");
            }
        } else {
            System.out.println("Usuário já possui o limite de livros emprestados.");
        }
    }

    public void devolverLivro(Usuario usuario, String titulo) {
        Livro livro = localizarLivroPorTitulo(titulo);
        if (livro != null) {
            livro.devolver();
            usuario.removerLivro();
            System.out.println("Devolução realizada com sucesso.");
        } else {
            System.out.println("Livro não encontrado para devolução.");
        }
    }

    public void exibirInfo() {
        System.out.println("Biblioteca: " + nome + ", Endereço: " + endereco +
                ", Livros Disponíveis: " + contadorLivros);
    }
}
