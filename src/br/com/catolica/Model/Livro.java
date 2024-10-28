package br.com.catolica.Model;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private int quantidadeEstoque;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, int quantidadeEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeEstoque = quantidadeEstoque;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void emprestar() {
        if (quantidadeEstoque > 0) {
            quantidadeEstoque--;
        } else {
            System.out.println("Livro não disponível em estoque.");
        }
    }

    public void devolver() {
        quantidadeEstoque++;
    }
    public void exibirInfo() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn +
                ", Ano: " + anoPublicacao + ", Quantidade em Estoque: " + quantidadeEstoque);
    }
}
