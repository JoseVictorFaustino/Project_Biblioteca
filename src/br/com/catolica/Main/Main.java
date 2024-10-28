package br.com.catolica.Main;

import br.com.catolica.Model.Livro;
import br.com.catolica.Model.Usuario;
import br.com.catolica.Model.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Rua Exemplo, 123");

        Livro livro1 = new Livro("Java: Como Programar", "Deitel", "123456789", 2020, 5);
        Livro livro2 = new Livro("Aprendendo Python", "Zed Shaw", "987654321", 2021, 3);
        Usuario usuario = new Usuario("Maria", "001", "maria@email.com");

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        biblioteca.verificarDisponibilidade("Java: Como Programar");
        biblioteca.verificarDisponibilidade("Aprendendo Python");
        biblioteca.verificarDisponibilidade("C++ para Iniciantes");

        biblioteca.emprestarLivro(usuario, "Java: Como Programar");
        biblioteca.emprestarLivro(usuario, "Aprendendo Python");

        biblioteca.emprestarLivro(usuario, "Java: Como Programar");

        biblioteca.devolverLivro(usuario, "Java: Como Programar");

        biblioteca.exibirInfo();
        usuario.exibirInfo();
        livro1.exibirInfo();
        livro2.exibirInfo();
    }
}
