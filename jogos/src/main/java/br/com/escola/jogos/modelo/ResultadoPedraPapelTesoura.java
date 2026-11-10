package br.com.escola.jogos.modelo;

public class ResultadoPedraPapelTesoura {
    private Jogada escolhaJogador;
    private Jogada escolhaComputador;
    private boolean venceu;
    private boolean empatou;
    private String mensagem;

    public ResultadoPedraPapelTesoura(Jogada escolhaJogador, Jogada escolhaComputador,
                                      boolean venceu, boolean empatou, String mensagem) {
        this.escolhaJogador = escolhaJogador;
        this.escolhaComputador = escolhaComputador;
        this.venceu = venceu;
        this.empatou = empatou;
        this.mensagem = mensagem;
    }

    public Jogada getEscolhaJogador() {
        return escolhaJogador;
    }

    public Jogada getEscolhaComputador() {
        return escolhaComputador;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public boolean isEmpatou() {
        return empatou;
    }

    public String getMensagem() {
        return mensagem;
    }
}