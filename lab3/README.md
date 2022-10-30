# IES_103453

## 3.1 Accessing databases in SpringBoot

### Alinea a)

Inicializacao de projeto atraves do spring boot, que cria um projeto Java Maven com as dependencias necessarias.

### Alinea b)

 - O userRepository e uma instancia de uma classe UserRepository, que corresponde a uma interface de um repositorio CRUD onde a informacao e guardada e acedida muito facilmente.
 
 - No exemplo dado, o userRepository tem os seguintes metodos:
      - save(objeto);
      - findAll();
      - findById(id);
      Os primeiros 2 metodos mencionados correspondem a metodos nativos da classe CrudRepository, onde a classe que instancia o objeto userRepository (UserRepository) corresponde a uma interface que extende esse CrudRepository.
      Ja o 3o metodo, corresponde a um metodo criado na interface extendida.
      
  - Assim sendo, toda a informacao e guardada nesse repositorio Crud.
  - Os enderecos de email nao podem ser vazios, descrito pela tag @NotBlank, que obriga o preenchimento dessa variavel por um valor nao nulo.
  
 ### Alinea c)
 
 Foram feitas alteracoes na parte html (na parte de add-user.html e adicionado um campo para a colocacao de um numero de telefone, bem como a label a indicar o que devera ser colocado nesse mesmo campo, bem como na pagina de index.html tambem foi adicionado um campo para visualizacao do numero de telemovel de todos os utilizadores inseridos ate ao momento. 
 Na classe user, foi adicionado um campo de modo a armazenar informacao sobre o numero de telefone, especificando que nao devera ser um campo vazio (tag @NotBlank), bem como os getters e setters desse mesmo campo.
 
 ## 3.2 Multilayer applications: exposing data with REST interface
 
 ### Alinea a)
 
Nesta alinea, foi posto num docker container uma imagem de um servidor MySQL, atraves do comando:
 
 ```$ docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1-e MYSQL_DATABASE=demo-e MYSQL_USER=demo-e MYSQL_PASSWORD=secret2-p 33060:3306-d mysql/mysql-server:5.7```
 
Deste modo, criamos um container de um servidor de uma base de dados a um docker, que pode ser acedido na porta 33060 do localhost.

### Alinea b)

Foi criado, atraves do guia mencionado no guiao dado, as entidades, base de dados e enpoint RESTfull de modo a criar uma aplicacao de gestao de empregados de uma dada empresa.
As alineas seguintes referem se a especificar como implementar tudo.

### Alinea c)

Criacao da classe Employee, com parametros de id, primeiro nome, ultimo nome e email, bem como os seus getters e setters, sendo que o ID e atribuido automaticamente.

### Alinea d)

Criacao de um repositorio que guarda objetos Employee, definida como EmployeeRepository, que e uma interface que este um CrudRepository.

### Alinea e)

Criacao de um controller REST que permite fazer o mapeamento da aplicacao, e, conforme esse mapeamento, permite executar funcoes que guardam, eliminam, etc instancias de Employee no repositorio instanciado.

### Alinea f)

Ligacao a base de dados no docker container atraves da insercao do log in a mesma, utilizado o ficheiro aplication.properties, que permite especificar a base de dados e os seus componentes na mesma.
Dessa forma, torna se possivel estabelecer ligacao da aplicacao java a uma base de dados que guarda a informacao sobre os employees.

### Alinea g) 

Criacao de um metodo que permite a procura de um employee atraves da insercao do email como parametro. E necessario extender o repositorio para admitir esse mesmo parametro, embora o consiga implementar de forma automatica, o que torna isto numa ferramenta muito poderosa.

## 3.3 Wrapping-up and integrating concepts

### Alinea a)

Este projeto apresenta um diferente output comparativamente ao guiao 2 entregado anteriormente, apesar de conter as mesmas funcionalidades.
Foram criadas 2 entidades diferentes:

  - Entidade Quote cujos parametros correspondem a uma String indicando o texto em si da quote, um id gerado automaticamente e um show, a qual a quote pertence.
  - Entidade Show cujos parametros correspondem a uma String indicando o titulo do filme, bem como o ano em que foi lancado.

E de notar que o paremetro Show na classe quote contem a anotacao @ManyToOne descrevendo a relacao entre as duas entidades, em que varias quotes podem corresponder a um unico filme.

Foram criados os respetivos repositorios para cada uma das entidades

### Alinea b)

Foi implementada uma nova classe (QuoteService) que, recebendo um repositorio, trata de executar varias operacao no mesmo, de uma forma "escondida" dos controladores que tratam de fazer o mapeamento da aplicacao e ao mesmo tempo comunicar com o repositorio. Assim, este servico permite estabelecer mais uma camada entre o controlador e o repositorio, que executa as suas ligacoes.

### Alinea c)

Atraves do service implementado na alinea anterior, foi possivel criar de uma forma mais eficaz os outros metodos de insercao de quotes (POST mapping).

## Review Questions

### Alinea a)

A notacao @Controller e utilizada para marcar uma determinada classe como um controlador spring MVC.
No entanto, a notacao @RestController e um controlador especial utilizado em RESTful Web services, que corresponde a combinacao de @Controller com @ResponseBody, o que permite fazer um handler de web requests.

### Alinea b)

![Diagram](https://user-images.githubusercontent.com/75539238/198859534-a0a47455-1eee-49a2-8d6c-8323ddff6f93.png)

O service estabelece ligacao entre o controlador e o repositorio da base de dados, sendo que em cada repositorio estao inseridas instancias de quotes e shows, separadamente.

### Alinea c)

@Table refere se uma dada tabela da base de dados, a qual podemos atribuir um nome, @Column, uma coluna dessa tabela, onde @Id refere-se a chave primaria de uma dada tabela, e que deve ser, portanto, um valor unico.

### Alinea d)

A anotacao @AutoWired permite que todas os beans num ficheiro de configuracao Spring consigam automaticamente estabelecer ligacao uns com os outros e encontra o que, e onde, precisa de ser injetado.
