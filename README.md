# Linter Pedagógico com IA (MVP)

![Java](https://img.shields.io/badge/Java-17%2B-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?logo=spring)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento%20(MVP)-orange)

## 1. Visão Geral

Este repositório contém o esboço (MVP) de uma API REST para o projeto "Linter Pedagógico". O objetivo principal é atuar como um "mentor digital" para programadores iniciantes.

Ao contrário de linters tradicionais que apenas apontam erros, esta API utiliza Inteligência Artificial para analisar snippets de código e fornecer um feedback focado no "porquê" das boas práticas, ajudando ativamente no processo de aprendizado.

Este MVP é construído em **Java** com o framework **Spring Boot**.

## 2. O Problema

Programadores iniciantes, especialmente estudantes, têm dificuldade em aplicar conceitos de *Clean Code*. Ferramentas atuais são "secas", frustrando o aprendizado. Este projeto visa preencher essa lacuna, oferecendo explicações pedagógicas e motivadoras.

## 3. Funcionalidades do MVP (API)

* **Endpoint de Análise:** Expõe um endpoint (`/analyze`) que recebe um snippet de código Java.
* **Análise Pedagógica:** Identifica problemas comuns de iniciantes (ex: variáveis não usadas, nomes inadequados, indentação).
* **Relatório JSON:** Retorna um relatório estruturado em JSON detalhando os problemas encontrados.
* **Feedback com IA:** Para cada problema, fornece uma explicação clara sobre *por que* aquilo é um problema e uma *sugestão* de como melhorar, tudo com um tom educacional.

## 4. Tecnologias Utilizadas

* **Backend:** Java 17+ e Spring Boot 3.x
* **Build Tool:** Maven (ou Gradle)
* **IA (Planejado):** Integração com uma API de LLM (ex: Google Gemini, OpenAI GPT) para geração do feedback pedagógico.
* **Testes:** JUnit 5 (planejado).

## 5. Como Executar o Projeto

### Pré-requisitos

* JDK 17 ou superior
* Apache Maven
* Uma chave de API para o serviço de IA que você irá utilizar (ex: Google AI Studio).

### Passos para Instalação e Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    cd seu-repositorio
    ```

2.  **Configure as Variáveis de Ambiente:**
    Crie ou edite o arquivo `src/main/resources/application.properties` (ou `.yml`) para incluir sua chave de API.

    *Exemplo (`application.properties`):*
    ```properties
    # Chave da API de IA (Exemplo para Gemini)
    ai.api.key=SUA_CHAVE_DE_API_AQUI

    # Porta do servidor (opcional)
    server.port=8080
    ```

3.  **Compile e Execute o projeto (via Maven Wrapper):**
    ```bash
    # No Windows
    ./mvnw spring-boot:run
    
    # No Linux/Mac
    ./mvnw spring-boot:run
    ```

4.  **Acesse a API:**
    O servidor estará rodando em `http://localhost:8080`.

## 6. Estrutura Proposta do Projeto (Spring)

Para organizar o esboço, sugerimos a seguinte estrutura de pacotes padrão: