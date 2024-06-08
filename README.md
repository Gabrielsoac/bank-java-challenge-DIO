# Aplicativo Bancário Simples

O projeto foi desenvolvido como um desafio para o BootCamp da Digital Innovation One (DIO) patrocinado pelo Santander em 2024.

### Ferramentas

-   Java 17
- Git


# Visão Geral

Este projeto é um aplicativo bancário simples desenvolvido em Java 17, demonstrando o uso de Programação Funcional com Stream API e expressões Lambda, junto com uma base sólida nos quatro pilares da Programação Orientada a Objetos (POO). O aplicativo é estruturado utilizando uma arquitetura baseada em interfaces e é projetado para lidar com operações bancárias básicas, como autenticação de usuários, registro de usuários, saques, depósitos, consultas de saldo e transferências de fundos.

##  Funcionalidades

- **Autenticação de Usuários**: Autenticar usuários de forma segura.
-   **Registro de Usuários**: Registrar novos usuários com os dados necessários.
-   **Operações Bancárias**:
    -   **Saque**: Realizar saques de uma conta.
    -   **Depósito**: Realizar depósitos em uma conta.
    -   **Consulta de Saldo**: Verificar o saldo de uma conta.
    -   **Transferência**: Transferir fundos entre contas.

## Arquitetura

O aplicativo é projetado usando uma arquitetura baseada em interfaces para garantir flexibilidade e escalabilidade. Interfaces definem as funcionalidades principais, e classes concretas fornecem as implementações. Esta abordagem adere aos princípios de programar para uma interface, não para uma implementação.

## Programação Orientada a Objetos (POO)

O projeto é construído com base nos quatro pilares da POO:

1.  **Encapsulamento**: Os campos de dados são mantidos privados e acessados através de métodos públicos.
2.  **Abstração**: Detalhes complexos de implementação são ocultados, expondo apenas as interfaces necessárias.
3.  **Herança**: Funcionalidades comuns são herdadas de classes base, promovendo o reuso de código.
4.  **Polimorfismo**: Diferentes objetos podem ser acessados através da mesma interface, permitindo flexibilidade e a capacidade de intercambiar componentes.

## Utilização da Stream API

**Filtragem de Usuários**: Ao autenticar um usuário, precisamos verificar se as credenciais fornecidas correspondem a algum usuário registrado.

**Listagem de Transações**: Para exibir o extrato de uma conta, utilizamos a Stream API para processar a lista de transações associadas à conta.

## Estrutura do Projeto

src/
├── application/
│   ├── Program.java
│
├── domain/
│   ├── entities/
│   │   ├── CurrentAccount.java
│   │   ├── MovementsAccount.java
│   │   ├── SavingsAccount.java
├────── enums/
│   │   ├── ─ MovementType.java
│   │
│   ├── infra/services
│   │   ├── AuthMovementService.java
│   │   ├── AuthMovementServiceImpl.java
│   │   ├── ExtractService.java
│   │   ├── ExtractServiceImpl.java
│   │
│   └── service/
│       ├── AccountService.java
│       ├── AccountServiceImpl.java
│       ├── AuthService.java
│       ├── AuthServiceImpl.java

## Funcionalidades

### Autenticação de Usuários

-   **Login**: Forneça as credenciais do usuário para autenticar.

### Registro de Usuários

-   **Register*: Crie uma nova conta de usuário fornecendo nome, data de nascimento, login e senha.

### Operações Bancárias

-   **Saque**: Especifique o valor a ser sacado da conta do usuário.
-   **Depósito**: Especifique o valor a ser depositado na conta do usuário.
-   **Consulta de Saldo**: Recupere o saldo atual da conta do usuário.
-   **Transferência**: Transfira um valor especificado da conta do usuário para outra conta.