package br.com.escola.jogos.modelo;

public class Jogador {
    private Jogada jogada;

    public void escolher(Jogada jogada) {
        this.jogada = jogada;
    }

    public boolean venceu(Jogada adversaria) {
        return jogada.vence(adversaria);
    }

    public boolean empatou(Jogada adversaria) {
        return jogada == adversaria;
    }
}