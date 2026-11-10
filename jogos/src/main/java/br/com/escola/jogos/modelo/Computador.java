package br.com.escola.jogos.modelo;

import java.util.Random;

public class Computador {
    private final Random random;

    public Computador() {
        this.random = new Random();
    }

    public Jogada escolher() {
        Jogada[] jogadas = Jogada.values();
        return jogadas[random.nextInt(jogadas.length)];
    }
}