# API's REST

Módulo dedicado ao apredizado e aplicação das API's REST

## O que são APIs?
Quando acessamos qualquer aplicação hoje em dia, lidamos com uma interface que nos permite acessar e utilizar a aplicação. Direfentes dispositivos possuem diferentes interfaces programadas, e que conseguem se conectar de acordo com as regras de negócio estabelecidas. Esse intermédio que permite as interfaces e aplicações diferentes conversarem entre sí, é conhecida como **API** ou Application Progamming Interface.

Essas API's podem ser disseminadas em diversos tipos, como quando um programamos um sistema nativo para computador utilizamos uma API fornecida pelo próprio sistema operacional por outro lado se programamos para dispositivos móveis como Android ou IOS utilizamos o as API fornecidas por esse sistemas para acesso a dados e gravação local.

Com as aplicações que rodam na internet precisamos padronizar como nossas APIs serão estruradas e disponibilizadas baseando e para isso é usado o protocolo HTTP. E buscando aplicar um padrão para o desenvolvimento e documentação foi implementado o padrão Rest.


	 

## Componentes da comunicação HTTP
|URL/URI    |Método (method)|Corpo (header)   |Cabeçalho (header)|
|-----------|---------------|-----------------|------------------|
|Localização|      Ação     |Dados a processar|Dados da chamada  |


## Arquitetura das APIs

Quando pensamos em arquitetura dentro da programação, pensamos em como construir algo que atende o que foi pedido dentro das restrições estabelecidas e também pensamos em como vamos aplicar as técnicas que conhecemos e quais técnologias iremos utilizar para viabilizar o projeto. 

Voltando as interfaces, podemos inferir que a API também se trata de uma interface que fica do lado do servidor (server-side), a para seu desenvolvimento temos que pensar em atender a chamada do cliente e como será entregue os dados. Por outro lado, a api tem que servir como um encapsulamento da regra de negócio, ou seja, para o cliente deve ser retornado a resposta com o mínimo de informações do projeto.
