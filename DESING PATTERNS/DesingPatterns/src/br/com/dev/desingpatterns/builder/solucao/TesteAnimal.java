package br.com.dev.desingpatterns.builder.solucao;

public class TesteAnimal {
    public static void main(String[] args) {
        Animal animal =  Animal.builder()
                .nome("Rex")
                .raca("Pitbull")
                .dono("Kelven")
                .build();
        System.out.println(animal);
    }
}
