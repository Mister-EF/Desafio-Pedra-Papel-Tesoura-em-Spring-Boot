# Pedra, Papel ou Tesoura

Jogo de Pedra, Papel ou Tesoura contra o computador, feito em Java com Spring Boot e jogado pelo navegador.

## Requisitos

- **JDK 25** (versão definida no `pom.xml`). Confira com `java -version`.
- **VS Code** com as extensões:
  - Extension Pack for Java
  - Spring Boot Extension Pack

Não é preciso instalar o Maven, pois o projeto usa o Maven Wrapper (`mvnw`).

## Como executar

1. **Baixe o projeto** e abra a pasta `jogos` no VS Code (File → Open Folder).
2. **Abra o arquivo** `JogosApplication.java`, em:
   ```
   src/main/java/br/com/escola/jogos/JogosApplication.java
   ```
3. **Rode o projeto**: clique em **Run** acima do método `main`.
   Alternativa pelo terminal do VS Code, na raiz do projeto:
   ```
   .\mvnw spring-boot:run      (Windows)
   ./mvnw spring-boot:run      (Linux/macOS)
   ```
4. **Acesse** http://localhost:8081/ no navegador e jogue.

Para parar o servidor, pressione `Ctrl + C` no terminal.

> A porta 8081 é definida em `src/main/resources/application.properties` (`server.port=8081`).

## Como jogar

Clique em **Pedra**, **Papel** ou **Tesoura**. O computador sorteia a jogada dele e a tela mostra o resultado.

| Jogada | Vence |
|---|---|
| Pedra | Tesoura |
| Papel | Pedra |
| Tesoura | Papel |

Se as duas jogadas forem iguais, o resultado é empate.

## Estrutura do projeto

```
jogos
├── .mvn
├── src
│   ├── main
│   │   ├── java/br/com/escola/jogos
│   │   │   ├── JogosApplication.java
│   │   │   ├── modelo
│   │   │   │   ├── Jogada.java
│   │   │   │   ├── Computador.java
│   │   │   │   ├── Jogador.java
│   │   │   │   └── ResultadoPedraPapelTesoura.java
│   │   │   ├── servico
│   │   │   │   └── JogoPedraPapelTesoura.java
│   │   │   └── controle
│   │   │       └── PedraPapelTesouraController.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   │           └── index.html
│   └── test
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

- **modelo:** as peças do jogo (as jogadas, o computador, o jogador e o resultado).
- **servico:** as regras do jogo.
- **controle:** recebe o pedido do navegador e devolve a resposta em JSON.
- **static:** a tela do jogo (HTML, CSS e JavaScript).

## Endpoint

```
GET /pedrapapeltesoura/jogar?escolha=pedra
```

Valores aceitos em `escolha`: `pedra`, `papel` ou `tesoura` (maiúsculas e minúsculas são aceitas). Qualquer outro valor devolve a mensagem "Opção inválida!".

Exemplo de resposta:

```json
{
  "escolhaJogador": "PEDRA",
  "escolhaComputador": "TESOURA",
  "venceu": true,
  "empatou": false,
  "mensagem": "Parabéns! Você ganhou: pedra vence tesoura!"
}
```

## Tecnologias

- Java 25
- Spring Boot 4.1.2 (Spring Web MVC)
- Maven (via Maven Wrapper)
- HTML, CSS e JavaScript no front-end