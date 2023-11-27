package br.com.dev.desingpatterns.builder.solucao;

import br.com.dev.desingpatterns.builder.Pessoa;

import java.time.LocalDate;

public class TestePessoaBuilder {
    public static void main(String[] args) {
        Pessoa pessoa =
            new Pessoa.PessoaBuilder().nome("Kelven")
            .sobreNome("Cristian")
            .documento("8599493481")
            .email("kelvencrstn@gmail.com")
            .apelido("kelvinho")
            .dataNascimento(LocalDate.of(2002, 3, 4))
            .build();

        System.out.println(pessoa);
    }
}
