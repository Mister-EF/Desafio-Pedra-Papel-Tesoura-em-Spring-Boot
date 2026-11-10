package br.com.escola.jogos.modelo;

public enum Jogada {
    PEDRA("pedra"),
    PAPEL("papel"),
    TESOURA("tesoura");

    private final String descricao;

    Jogada(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean vence(Jogada outra) {
        return (this == PEDRA && outra == TESOURA)
                || (this == PAPEL && outra == PEDRA)
                || (this == TESOURA && outra == PAPEL);
    }

    public static Jogada deTexto(String texto) {
        for (Jogada jogada : Jogada.values()) {
            if (jogada.descricao.equalsIgnoreCase(texto.trim())) {
                return jogada;
            }
        }
        throw new IllegalArgumentException("Jogada inválida: " + texto);
    }
}