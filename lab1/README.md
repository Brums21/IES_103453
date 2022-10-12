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

## lab 1.5

Para este guiao foram criados dois projetProject → Properties → Target Runtimes → Apache Tomcaos maven, um com o ficheiro main do projeto do lab 1.2 e outro projeto separado com os restantes ficheiros da api que tratavam da parte logica. O projeto Maven com o ficheiro main tem groupID="mainproj" e artifactID="weatherforecast".

Ja o outro projetot tem groupID="ipmapiclient" e artifactID="com.apiclient".

Foi executado o comando ```mvn clean install -DskipTests``` de modo a gerar o ficheiro .jar correspondente a esse ficheiro.
De seguida, criei a pasta "lib" dentro do mainproj, e copiei o ficheiro jar para dentro do mesmo.

Adicionalemente, foi colocado no ficheiro POM a dependencia correpondente a esse ficheiro:

```
<dependency>
      <groupId>com.apiclient</groupId>
      <artifactId>apiclient</artifactId>
      <scope>system</scope>
      <version>0.0.1-SNAPSHOT</version>
      <systemPath>${project.basedir}/lib/ipmapiclient.jar</systemPath>
    </dependency>
```

Desse modo, o projeto main consegue ser executado de forma independente.


## Review questions 

A) O ciclo de vida "default" tem a funcao de implantar o projeto, o ciclo de vida "clean" tem a funcao de tratar de limpar o projeto e o "site", a funcao de tratar da documentacao local.

B) O projeto maven define a maneira como os ficheiros java sao compilados e "transformados" em ficheiros .jar sem necessitar de outras ferramentas mais complexas, tratando de diminuir a complexidade da compilacao de varios projetos.

C) Uma sequencia de comandos git seria:
    git add <nome do ficheiro modificado>
    git commit -m "mensagem a apresentar"
    git push

D) As mensagens de git commit devem ser breves, mas ter a informacao adequada a cada modificacao efetuada. Por exemplo, na adicao de uma funcionalidade x, um exemplo de uma mensagem de commit adequada seria, na minha opiniao, "implementacao da funcionalidade x".

E) No caso de base de dados, que sao elementos que contem informacao importante e que seria bastante custoso ser perdida, e preferivel a utilizacao de volumes ao inves do espaco criado automaticamente pelo docker, uma vez que quando o container do docker deixa de existir, toda a informacao e perdida (nao persiste, ao contrario de quando se configura um volume de espaco manualmente).
