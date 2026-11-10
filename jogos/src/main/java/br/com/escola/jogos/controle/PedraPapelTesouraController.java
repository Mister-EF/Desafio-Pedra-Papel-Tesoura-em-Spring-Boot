package br.com.escola.jogos.controle;

import br.com.escola.jogos.modelo.ResultadoPedraPapelTesoura;
import br.com.escola.jogos.servico.JogoPedraPapelTesoura;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedrapapeltesoura")
public class PedraPapelTesouraController {
    private final JogoPedraPapelTesoura jogo;

    public PedraPapelTesouraController(JogoPedraPapelTesoura jogo) {
        this.jogo = jogo;
    }

    @GetMapping("/jogar")
    public ResultadoPedraPapelTesoura jogar(@RequestParam String escolha) {
        return jogo.jogar(escolha);
    }
}