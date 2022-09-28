# IES_103453

## Java version:

javac 17.04.4

## Setup maven

Foi dado setup das variáveis de modo a conseguir posteriormente a instalacao da interface maven.

## versao git:

git version 2.25.1
Nota: git config --list demonstra o e-mail e o username associados.

### Outras anotacoes a ter em consideracao:

Um lifecycle maven e constituido por varias fases:
    - validate
    - compile
    - test
    - package
    - verify
    - install
    - deploy 

O ciclo de vida default corresponde a execucao sequencial das fases anteriores, de inicio ao fim.

Para a execucao dos projetos maven, ira ser utilizado o IDE VS Code.

## Dependencias

Foram adicionadas as dependencias necessarias, e, apos modificacao do programa como pedido na alinea k, o programa agora recebe os ids, mostrando as correpondentes temperaturas.

Codigo a executar na bash:

```$ mvn exec:java -Dexec.mainClass="com.myweatherradar.app.WeatherStarter" -Dexec.args=1010500```

## nota importante

O portainer e o teste do docker Compose (mais especificamente, o projeto web), estao ambos a utilizar a mesma porta (8000) pelo que so pode estar ligado um de cada vez.