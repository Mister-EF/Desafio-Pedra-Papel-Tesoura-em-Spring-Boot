package br.com.escola.jogos.servico;

import br.com.escola.jogos.modelo.Computador;
import br.com.escola.jogos.modelo.Jogada;
import br.com.escola.jogos.modelo.Jogador;
import br.com.escola.jogos.modelo.ResultadoPedraPapelTesoura;
import org.springframework.stereotype.Service;

@Service
public class JogoPedraPapelTesoura {
    private final Computador computador;

    public JogoPedraPapelTesoura() {
        this.computador = new Computador();
    }

    public ResultadoPedraPapelTesoura jogar(String textoDaEscolha) {
        Jogada escolha;
        try {
            escolha = Jogada.deTexto(textoDaEscolha);
        } catch (IllegalArgumentException e) {
            return new ResultadoPedraPapelTesoura(null, null, false, false,
                    "Opção inválida! Escolha 'pedra', 'papel' ou 'tesoura'.");
        }

        Jogador jogador = new Jogador();
        jogador.escolher(escolha);

        Jogada escolhaComputador = computador.escolher();

        if (jogador.empatou(escolhaComputador)) {
            return new ResultadoPedraPapelTesoura(escolha, escolhaComputador, false, true,
                    "Empate! Os dois escolheram " + escolha.getDescricao() + ".");
        } else if (jogador.venceu(escolhaComputador)) {
            return new ResultadoPedraPapelTesoura(escolha, escolhaComputador, true, false,
                    "Parabéns! Você ganhou: " + escolha.getDescricao()
                            + " vence " + escolhaComputador.getDescricao() + "!");
        } else {
            return new ResultadoPedraPapelTesoura(escolha, escolhaComputador, false, false,
                    "Você perdeu! " + escolhaComputador.getDescricao()
                            + " vence " + escolha.getDescricao() + ".");
        }
    }
}