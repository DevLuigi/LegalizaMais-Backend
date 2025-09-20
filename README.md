
<div align="center">
    <h1>  Legaliza+ - Plataforma de gestão de contratos e orçamentos  </h1>
</div>


<div align="center">
   <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=RED&style=for-the-badge" alt="badge-em-desenvolvimento"/>
</div>

<br>

### Tópicos 

- [Descrição do projeto](#descrição-do-projeto)

- [Funcionalidades](#funcionalidades)

- [Ferramentas utilizadas](#ferramentas-utilizadas)

- [Acesso ao projeto](#acesso-ao-projeto)

- [Como rodar o projeto](#como-rodar-o-projeto)

- [Desenvolvedores](#desenvolvedores)


<br>

## Descrição do projeto 

<p align="justify">
O Legaliza+ é um sistema web desenvolvido para profissionais autônomos, com o objetivo de simplificar a gestão de orçamentos e contratos. A plataforma permite o cadastro de usuários, clientes e serviços, além da criação e gerenciamento de orçamentos que podem ser convertidos em contratos de forma automática. Para facilitar a comunicação com os clientes, os documentos podem ser enviados diretamente por WhatsApp ou e-mail, bem como baixados em PDF. Dessa forma, o Legaliza+ oferece uma solução prática e acessível, ajudando autônomos a organizarem seus processos, reduzirem burocracias e transmitirem mais credibilidade e profissionalismo em seus atendimentos.
<br>

## Funcionalidades

:heavy_check_mark: `Funcionalidade 1:` Cadastro de usuários.

:heavy_check_mark: `Funcionalidade 2:` Login de usuários.

:heavy_check_mark: `Funcionalidade 3:` CRUD de clientes.

:heavy_check_mark: `Funcionalidade 4:` CRUD de serviços.

:heavy_check_mark: `Funcionalidade 5:` CRUD de orçamentos.

:heavy_check_mark: `Funcionalidade 6:` Geração de contratos.

<br>

## Ferramentas utilizadas
[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff)](#)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=fff)](#)
[![Git](https://img.shields.io/badge/Git-F05032?logo=git&logoColor=fff)](#)
###

<br>

## Acesso ao projeto

Você pode [acessar o código fonte do projeto front-end](https://github.com/DevLuigi/LegalizaMais-Frontend).

<br>

## Como rodar o projeto

Para executar este projeto localmente, siga os passos abaixo:

1 - Clone o repositório:
~~~bash
  git clone https://github.com//DevLuigi/LegalizaMais-Backend.git
~~~

2 - Acesse o diretório do projeto:
~~~bash
  cd substitua/pelo/diretorio/onde/foi/clonado/LegalizaMais-Backend
~~~

3 - Configure as variáveis de ambiente:
Altere o arquivo application.properties no diretório src/main/resources, e defina as configurações do banco de dados e demais variáveis exigidas pelo projeto. Exemplo básico:
~~~bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
~~~

4 - Compile o projeto com Maven:
~~~bash
  ./mvnw clean install
~~~

5 - Execute a aplicação:
~~~bash
  ./mvnw spring-boot:run
~~~

6 - Acesse a API:
A aplicação será executada em http://localhost:8080 (por padrão). Você pode testar os endpoints utilizando ferramentas como Postman, Insomnia ou via cURL.

<br>

## Desenvolvedores

| [<img src="https://avatars.githubusercontent.com/u/159407896?v=4" width=115><br><sub>André Santos da Silva</sub>](https://github.com/ngxdre)   | [<img src="https://avatars.githubusercontent.com/u/159090497?v=4" width=115><br><sub>Breno Carneiro Bosan Camilo</sub>](https://github.com/Brenuu)     |  [<img src="https://avatars.githubusercontent.com/u/142193648?v=4" width=115><br><sub>Eduardo Matos</sub>](https://github.com/eduardomts1)              |  [<img src="https://avatars.githubusercontent.com/u/127437017?v=4" width=115><br><sub>João Victor Soares</sub>](https://github.com/joaosoares03)        |  [<img src="https://avatars.githubusercontent.com/u/89988223?v=4" width=115><br><sub>Kaio da Silva Coelho</sub>](https://github.com/Kaio-Silva)         | [<img src="https://avatars.githubusercontent.com/u/89977964?s=400&u=a0d21d2cf86edf9e2f66bcef496882e445f38f6d&v=4" width=115><br><sub>Luigi da Silva Coelho</sub>](https://github.com/DevLuigi) |
| :---: | :---: | :---: | :---: | :---: | :---: 
