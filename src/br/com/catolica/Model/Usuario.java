package br.com.catolica.Model;

public class Usuario {
    private String nome;
    private String id;
    private String email;
    private int livrosEmPosse;

    public Usuario(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.livrosEmPosse = 0;
    }

    public boolean podeEmprestar() {
        return livrosEmPosse < 5;
    }

    public void adicionarLivro() {
        if (podeEmprestar()) {
            livrosEmPosse++;
        } else {
            System.out.println("Limite de livros em posse alcançado.");
        }
    }

    public void removerLivro() {
        if (livrosEmPosse > 0) {
            livrosEmPosse--;
        }
    }
    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", ID: " + id + ", Email: " + email);
    }

}
