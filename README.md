# Anampet

O Anampet é um sistema web que irá auxiliar médicos veterinários a gerenciar seus atendimentos domiciliares em, inicialmente, caninos e felinos. Contando com um formulário em formato de anamnese prático e estruturado, o sistema permite ao *MedVet* protocolar o atendimento e sempre buscar analisar todo o quadro do Pet. Também, controlar a aplicação de vacinas, prescrições de remédios, histórico de peso do animal e muito mais!

# Desenvolvimento

Desenvolvido para o meu Trabalho de Conclusão de Curso do Tecnólogo em Análise e Desenvolvimento de Sistemas pela faculdade Instituto Federal de São Paulo - Campus Hortolândia, o sistema web foi desenvolvido da seguinte forma: 

## Levantamento de requisitos

Foi consultado um profissional formado e que atua à domicílio na área de medicina veterinária. Foram realizados duas entrevistas para coletar todos os requisitos do sistema. 

## Metodologia

O método de desenvolvimento escolhido para o desenvolvimento foi o Scrum, aonde após a criação do *Product Backlog*, a construção do sistema veio ao decorrer de *sprints* quinzenais e adaptações ao decorrer delas.

## Tecnologias

Para concretizar a criação do sistema, foram determinadas as seguintes tecnologias para o desenvolvimento:

### Back-end

A linguagem escolhida para a implementação da API REST que irá disponibilizar os *endpoints* e todas as regras de negócio da aplicação foi o Java. Juntamente, foi utilizado seus principais frameworks, como o Spring e seus diversos módulos (Spring Boot, Spring Security, Spring Data, etc.), JPA Hibernate, Lombok, Swagger, entre outros.

### Front-end

Para a parte visual do sistema, foi utilizado a biblioteca React.js e o framework Bootstrap para a responsividade do sistema.

### Banco de dados

O Banco de dados MySQL foi utilizado como banco de dados relacional.

### Infraestrutura

O sistema foi colocado em containers em Docker para assegurar um ambiente padronizado para execução do mesmo. Para os testes dos endpoints da aplicação, foi usado o Postman e para desenvolvimento geral da aplicação, o IntelliJ foi a IDE escolhida.

## Diagramas da aplicação

…
