# Sobre o projeto

Este é um projeto que utiliza Spring + Hibernate. Seu propósito é gerenciar comics da Marvel para usuários.

Ele possui três endpoints: cadastro de usuário, cadastro de comics da Marvel e recuperação de comics para um dado usuário. Cada um tem requisitos bem definidos:

1. Cadastro de usuário: deve ter nome, e-mail, CPF e data de nascimento, sendo que e-mail e CPF devem ser únicos.

2. Cadastro de comics: são obrigatórios os dados: Título, Preço e Autores, o ISBN e Descrição. Sendo que o serviço deve consumir a API da MARVEL (https://developer.marvel.com/) para obter os dados do Comics baseado nos dados informados

3. Busca de comics por usuário: deve retornar os comics de um usuário e calcular o desconto em um dia específico da semana definido pelo final do ISBN.

Para a organização do projeto utilizamos uma arquitetura em camadas:

<img width="767" alt="camadas" src="https://user-images.githubusercontent.com/53572999/124838867-10ff0380-df5e-11eb-9a9b-70c2258c438a.png">

Em que:

- Web Layer - contém os recursos da API, ou seja, os endpoints. Nosso pacote se chama “resource”, mas também é conhecido como controller. Poderia ser complementado com o “View” do citado MVC, mas não é nosso caso, já que trata-se de uma aplicação “Server side”, ou, backend. Então, podemos dizer que é a camada “Controller” do MVC
- Service Layer - nossa camada de serviço, onde focaremos a lógica das regras requisitadas. 
- Repository Layer - junto do service layer, englobam o “Model” do MVC. Na verdade, o Model não deixa explícito o acesso a dados, ou seja, a interface com nossa base de dados. Na literatura ele é focado nas validações, ou, regras de negócio. No nosso caso, evitamos colocar qualquer regra na camada de repository, pois sua responsabilidade é exclusivamente “conversar” com o banco de dados e realizar as operações necessárias solicitadas pela camada de serviço.
- As camadas de Domain e DTO’s são os objetos transitados no sistema. Ou seja, o Domain (domínio) é uma representação das nossas entidades relacionais (tabelas do banco de dados) em forma de objetos Java. É utilizando essas classes que o Hibernate consegue interpretar e converter objetos em entidades e vice-versa. Já os DTO’s, que no nosso projeto serão separados em Form e View, são os objetos recebidos e devolvidos nas requisições.

# Como rodar o projeto localmente

Para subir o projeto e utilizá-lo localmente você deve clonar o projeto, ou fazer download. Primeiro deve assegurar que na sua máquina você tem o Java 11 instalado. Veja [aqui](https://www.jackrutorial.com/2018/10/how-to-install-java-jdk-11-on-windows-10.html) como instalar o Java na sua máquina.

Na sua IDE de preferência, execute o método principal da aplicação, chamado "ComicsApplication". Abaixo um exemplo no IntelliJ:

![rodar spring](https://user-images.githubusercontent.com/53572999/124838912-2d9b3b80-df5e-11eb-927b-e973eb1576f3.png)

# Testar o projeto

Existe uma coleção com os recursos e requisições montadas no Postman. Acesse: [link](https://www.getpostman.com/collections/bdc6670136f5ee79fe95)
